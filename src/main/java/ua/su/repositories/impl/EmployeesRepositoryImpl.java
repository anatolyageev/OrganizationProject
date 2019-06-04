package ua.su.repositories.impl;
/**
 * Created by User on 5/30/2019.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.su.domain.Employees;
import ua.su.repositories.RepositoryEmployees;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class EmployeesRepositoryImpl implements RepositoryEmployees {
    private static final BeanPropertyRowMapper<Employees> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Employees.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employees> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees;", ROW_MAPPER);
    }

    @Override
    public Employees getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Employees insert(Employees employees) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into employees(name, surname, position, maritalStatus, yearsWorked) values (?,?,?,?,?)",
                    new String[] { "id" });
            ps.setString(1, employees.getName());
            ps.setString(2, employees.getSurname());
            ps.setString(3, employees.getPosition());
            ps.setBoolean(4, employees.getMaritalStatus());
            ps.setFloat(5, employees.getYearsWorked());
            return ps;
        }, keyHolder);
        long employeeId = keyHolder.getKey().longValue();
        return getOne(employeeId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employees where id = ?", id);
    }

    @Override
    public Employees update(Long id, Employees employees) {
        jdbcTemplate.update("update organizations set name = ?, surname = ?, maritalStatus = ? where id = ?",
                employees.getName(), employees.getSurname(), employees.getMaritalStatus(), id);
        return getOne(id);
    }
}
