package com.csys.parametrage.service;

import com.csys.parametrage.domain.Service;
import com.csys.parametrage.dto.ServiceDTO;
import com.csys.parametrage.factory.ServiceFactory;
import com.csys.parametrage.repository.ServiceRepository;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Service.
 */
@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

    private final Logger log = LoggerFactory.getLogger(ServiceService.class);
    
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

  
    /**
     *  Get all the services.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<ServiceDTO> findAll() {
        log.debug("Request to get all Services");
        List<Service> result = serviceRepository.findAll();

        return ServiceFactory.serviceCollectionToServiceDTOCollection(result);
    }

    /**
     *  Get one service by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public ServiceDTO findOne(Integer id) {
        log.debug("Request to get Service : {}", id);
        Service service = serviceRepository.findOne(id);
        return ServiceFactory.serviceTOServiceDTO(service);
    }

        @Transactional(readOnly = true)
    public Collection<ServiceDTO> findByActifIn(Collection<Boolean> actif) {
        log.debug("Request to get service by actif : {}", actif);
        List<Service> services = serviceRepository.findByActifIn(actif);
        return ServiceFactory.serviceCollectionToServiceDTOCollection(services);
    }
}
