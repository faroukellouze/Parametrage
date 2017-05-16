package com.csys.parametrage.factory;

import com.csys.parametrage.domain.Service;
import com.csys.parametrage.dto.ServiceDTO;
import java.util.ArrayList;
import java.util.Collection;

public class ServiceFactory {

    public static Service serviceDTOTOService(ServiceDTO serviceDTO) {
        if (serviceDTO == null) {
            return null;
        }

        Service service = new Service();

        service.setCode(serviceDTO.getCode());
        service.setDesignationAr(serviceDTO.getDesignationAr());
        service.setDesignation(serviceDTO.getDesignation());
        service.setActif(serviceDTO.isActif());
        service.setUserCreation(serviceDTO.getUserCreation());
        service.setDateCreation(serviceDTO.getDateCreation());
        return service;
    }

    public static ServiceDTO serviceTOServiceDTO(Service service) {
        if (service == null) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setCode(service.getCode());
        serviceDTO.setDesignationAr(service.getDesignationAr());
        serviceDTO.setDesignation(service.getDesignation());
        serviceDTO.setActif(service.isActif());
        serviceDTO.setUserCreation(service.getUserCreation());
        serviceDTO.setDateCreation(service.getDateCreation());
        return serviceDTO;
    }

    public static Collection<Service> serviceDTOCollectionToServiceCollection(Collection<ServiceDTO> serviceDTOCollection) {
        if (serviceDTOCollection == null) {
            return null;
        }

        Collection<Service> collection = new ArrayList<Service>();
        for (ServiceDTO serviceDTO : serviceDTOCollection) {
            collection.add(serviceDTOTOService(serviceDTO));
        }

        return collection;
    }

    public static Collection<ServiceDTO> serviceCollectionToServiceDTOCollection(Collection<Service> serviceCollection) {
        if (serviceCollection == null) {
            return null;
        }

        Collection<ServiceDTO> collection = new ArrayList<ServiceDTO>();
        for (Service service : serviceCollection) {
            collection.add(serviceTOServiceDTO(service));
        }

        return collection;
    }
    
     public static Service createServiceByCode(int code) {
        Service service = new Service();
        service.setCode(code);
        return service;
    }
}
