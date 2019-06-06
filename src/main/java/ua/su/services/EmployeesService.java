package ua.su.services;

import ua.su.domain.Employees;
import java.util.List;
/**
 * Created by User on 5/20/2019.
 */
public interface EmployeesService {
    List<Employees> getAll();
    Employees getOne(Long id);
    void deleteEmployees(Long id);
    Employees createEmployees(Long organizationId, Employees employees);
}
