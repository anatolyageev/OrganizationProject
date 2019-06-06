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
import ua.su.domain.Organization;
import ua.su.repositories.OrganizationRepository;

import javax.validation.constraints.NotNull;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {
    private static final BeanPropertyRowMapper<Organization> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Organization.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrganizationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Organization> findAll() {
        return jdbcTemplate.query("SELECT * FROM organizations;", ROW_MAPPER);
    }

    @Override
    public Organization getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM organizations WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Organization insert(Organization organization) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO organizations(name, phoneNumber, adress, reg, county, city , active, cpecialization, officeNumber) " +
                            "values (?,?,?,?,?,?,?,?,?,?)",
                            new String[] { "id" });
            ps.setString(1, organization.getName());
            ps.setString(2, organization.getPhoneNumber());
            ps.setString(3, organization.getAdress());
            ps.setString(5, organization.getReg().name());
            ps.setString(6, organization.getCountry());
            ps.setString(7, organization.getCity());
            ps.setBoolean(8, organization.getActive());
            ps.setString(9, organization.getCpecialization());
            ps.setInt(10, organization.getOfficeNumber());
            return ps;
        }, keyHolder);
        long organizationId = keyHolder.getKey().longValue();
        return getOne(organizationId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM organizations WHERE id = ?", id);
    }

    @Override
    public Organization update(Long id, Organization organization) {
        jdbcTemplate.update("UPDATE organizations SET name = ?, adress = ?, active = ? WHERE id = ?",
                organization.getName(), organization.getAdress(), organization.getActive(), id);
        return getOne(id);
    }

    public List<Organization> FindListCountries(Integer employeeNum){
        return jdbcTemplate.query("SELECT DISTINCT t1.country\n" +
                "FROM organizations t1,\n" +
                "( SELECT employees.organizations_id,\n" +
                "count(employees.id) AS emploee_num\n" +
                "FROM employees\n" +
                "GROUP BY employees.organizations_id) t2\n" +
                "WHERE t1.id = t2.organizations_id AND t2.emploee_num > ? AND t1.region::text = 'EUROPE'::text\n" +
                "ORDER BY t1.country;",
                ROW_MAPPER, employeeNum);
    }
}
