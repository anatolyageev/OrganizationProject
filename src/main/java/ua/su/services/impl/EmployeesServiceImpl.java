package ua.su.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.su.domain.Employees;
import ua.su.domain.Organization;
import ua.su.repositories.OrganizationRepository;
import ua.su.repositories.RepositoryEmployees;
import ua.su.services.EmployeesService;
import java.util.List;

@Component
public class EmployeesServiceImpl implements  EmployeesService{
    private final OrganizationRepository organizationRepository;
    private final RepositoryEmployees repositoryEmployees;

    @Autowired
    public EmployeesServiceImpl(OrganizationRepository organizationRepository, RepositoryEmployees repositoryEmployees){
        this.organizationRepository = organizationRepository;
        this.repositoryEmployees = repositoryEmployees;
    }

    @Override
    public List<Employees> getAll() {
        return repositoryEmployees.findAll();
    }

    @Override
    public Employees getOne(Long id) {
        return repositoryEmployees.getOne(id);
    }

    @Override
    public void deleteEmployees(Long id) {
        repositoryEmployees.delete(id);
    }

    @Override
    public Employees createEmployees(Long organizationId, Employees employees) {
        Organization organization = organizationRepository.getOne(organizationId);
        if (organization == null) {
            throw new RuntimeException("Organization not found");
        }
        return repositoryEmployees.insert(organizationId,employees);
    }


}
