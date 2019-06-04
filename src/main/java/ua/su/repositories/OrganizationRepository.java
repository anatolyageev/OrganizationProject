package ua.su.repositories;
/**
 * Created by User on 5/20/2019.
 */
import ua.su.domain.Organization;
import java.util.List;

public interface OrganizationRepository {
    List<Organization> findAll();
    Organization getOne(Long id);
    Organization insert(Organization organization);
    void delete(Long id);
    Organization update(Long id, Organization organization);
}
