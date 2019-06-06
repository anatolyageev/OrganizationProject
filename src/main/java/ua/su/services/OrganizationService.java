package ua.su.services;
/**
 * Created by User on 5/20/2019.
 */
import ua.su.domain.Organization;
import java.util.List;

public interface OrganizationService {
    List<Organization> getAll();
    Organization getOne(Long id);
    void deleteOrganization(Long id);
    Organization createOrganization(Organization organization);
    
}
