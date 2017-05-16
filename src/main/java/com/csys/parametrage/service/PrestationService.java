package com.csys.parametrage.service;

import com.csys.parametrage.domain.FamilleFacturation;
import com.csys.parametrage.domain.FamillePrestation;
import com.csys.parametrage.domain.Param;
import com.csys.parametrage.domain.Prestation;
import com.csys.parametrage.projection.PrestationCodeDes;
import com.csys.parametrage.domain.SousFamillePrestation;
import com.csys.parametrage.domain.Tva;
import com.csys.parametrage.domain.TypePrestation;
import com.csys.parametrage.dto.PrestationDTO;
import com.csys.parametrage.dto.SousFamillePrestationDTO;
import com.csys.parametrage.factory.FamillePrestationFactory;
import com.csys.parametrage.factory.PrestationFactory;
import com.csys.parametrage.factory.SousFamillePrestationFactory;
import com.csys.parametrage.repository.PrestationRepository;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service Implementation for managing Prestation.
 */
@Service
@Transactional
public class PrestationService {

    private final Logger log = LoggerFactory.getLogger(PrestationService.class);

    private final PrestationRepository prestationRepository;

    private final FamillePrestationService famillePrestationService;  // avoir 

    private final ParamService paramService;

    public PrestationService(PrestationRepository prestationRepository, @Lazy FamillePrestationService famillePrestationService, ParamService paramService) {//
        this.prestationRepository = prestationRepository;
        this.famillePrestationService = famillePrestationService;
        this.paramService = paramService;
    }

    /**
     * Save a prestation.
     *
     * @param prestationDTO
     * @return the persisted entity
     */
    public Boolean save(PrestationDTO prestationDTO) {
        log.debug("Request to save Prestation : {}", prestationDTO);
        prestationDTO.setCode(1);
        int codeFamille = prestationDTO.getCodeSousFamille().getCodeFamille().getCode();
        FamillePrestation famille = famillePrestationService.findByCode(codeFamille);
        Preconditions.checkArgument(famille != null, "error.ressourceNotFound");
        String codeSaisie = famille.getPrefixe() + String.format("%04d", famille.getSuffixe());
        Prestation prest = prestationRepository.findByCodeSaisie(codeSaisie);
        Preconditions.checkArgument(prest == null, "error.codeInvalide");
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        prestationDTO.setCode(null);
        Prestation prestation = new Prestation();
        SousFamillePrestation souFam = new SousFamillePrestation();
        prestation.setCodeSousFamille(souFam);
        Tva tva = new Tva();
        TypePrestation typePrestation = new TypePrestation();
        FamilleFacturation familleFacturation = new FamilleFacturation();
        prestation.setTva(tva);
        prestation.setCodeTypePrestation(typePrestation);
        prestation.setCodeFamilleFacturation(familleFacturation);
        prestation = PrestationFactory.prestationDTOTOPrestation(prestationDTO, prestation);
        prestation.setUserCreate(user);
        prestation.setDateCreate(new Date());
        prestation.setCodeSaisie(codeSaisie);
        prestationRepository.save(prestation);
        famille.setSuffixe(famille.getSuffixe() + 1);
        famillePrestationService.updateSuffixe(famille);
        return true;
    }

    /**
     * Get all the prestations.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<PrestationDTO> findAll() {
        log.debug("Request to get all Prestations");
        List<Prestation> result = prestationRepository.findAll();
        return PrestationFactory.listPrestationTOlistPrestationDTO(result);
    }

    /**
     * Get one prestation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public PrestationDTO findOne(Integer id) {
        log.debug("Request to get Prestation : {}", id);
        Prestation prestation = prestationRepository.findOne(id);
        Preconditions.checkArgument((prestation != null), "error.ressourceNotFound");
        return PrestationFactory.prestationTOPrestationDTO(prestation);
    }

    /**
     * Delete the prestation by id.
     *
     * @param id the id of the entity
     */
    public void delete(Integer id) {
        log.debug("Request to delete Prestation : {}", id);
        Preconditions.checkArgument(id != null, "error.ressourceNotFound");
        Preconditions.checkArgument(prestationRepository.exists(id), "error.ressourceNotFound");
        prestationRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<PrestationDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get Prestation by actif : {}", actif);
        List<Prestation> prestaion = prestationRepository.findByActifIn(actif);
        return PrestationFactory.listPrestationTOlistPrestationDTO(prestaion);
    }

    @Transactional(readOnly = true)
    public List<PrestationDTO> findByCodeSousFamilleCode(Integer codeSousFamille) {
        log.debug("Request to get Prestation by codeSousFamille : {}", codeSousFamille);
        List<Prestation> prestaion = prestationRepository.findByCodeSousFamilleCode(codeSousFamille);
        return PrestationFactory.listPrestationTOlistPrestationDTO(prestaion);
    }

    public Boolean update(PrestationDTO prestationDto) {
        log.debug("Request to update prestation : {}", prestationDto);
        Preconditions.checkArgument((prestationDto.getCode() != null), "error.ressourceNotFound");
        Prestation prestation = prestationRepository.findOne(prestationDto.getCode());
        Preconditions.checkArgument(prestation != null, "error.ressourceNotFound");
        prestationDto.setCodeSaisie(prestation.getCodeSaisie());
        SousFamillePrestation souFam = new SousFamillePrestation();
        Tva tva = new Tva();
        TypePrestation typePrestation = new TypePrestation();
        FamilleFacturation familleFacturation = new FamilleFacturation();
        prestation.setCodeSousFamille(souFam);
        prestation.setTva(tva);
        prestation.setCodeTypePrestation(typePrestation);
        prestation.setCodeFamilleFacturation(familleFacturation);
        prestation = PrestationFactory.prestationDTOTOPrestation(prestationDto, prestation);
        prestationRepository.save(prestation);
        return true;
    }

    @Transactional(readOnly = true)
    public List<PrestationCodeDes> findByActifInCodeTypePrestationCodeIn(Collection<Boolean> actif) {
        log.debug("Request to get Prestation by actif ,TypePrestation ");
        Param prestSjour = paramService.findOne("typePrestSejour");
        Preconditions.checkArgument(prestSjour != null, "error.ressourceNotFound");
        List<Integer> typePrestation = new ArrayList<>();
        typePrestation.add(Integer.valueOf(prestSjour.getValeur()));
        List<PrestationCodeDes> prestaion = prestationRepository.findByActifInAndCodeTypePrestationCodeIn(actif, typePrestation);
        return prestaion;
    }
}
