package ua.su.repositories;
import ua.su.domain.Employees;
import java.util.List;
/**
 * Created by User on 5/20/2019.
 */
public interface RepositoryEmployees {
    List<Employees> findAll();
    Employees getOne(Long id);
    Employees insert(Employees employees);
    void delete(Long id);
    Employees update(Long id, Employees employees);
}
