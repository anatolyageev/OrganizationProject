package ua.su.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.su.domain.Organization;
import ua.su.repositories.OrganizationRepository;
import ua.su.repositories.RepositoryEmployees;
import ua.su.services.OrganizationService;
import java.util.List;

@Component
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final RepositoryEmployees repositoryEmployees;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, RepositoryEmployees repositoryEmployees){
        this.organizationRepository = organizationRepository;
        this.repositoryEmployees = repositoryEmployees;
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOne(Long id) {
        return organizationRepository.getOne(id);
    }

    @Override
    public void deleteOrganization(Long id) {
        repositoryEmployees.deleteByOrganizationId(id);
        organizationRepository.delete(id);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.insert(organization);
    }
}
