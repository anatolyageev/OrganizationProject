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
        return jdbcTemplate.query("SELECT * FROM cats;", ROW_MAPPER);
    }

    @Override
    public Organization getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cats WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Organization insert(Organization organization) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into cats(name, color, is_multy_color) values (?, ?, ?)",
                            new String[] { "id" });
            ps.setString(1, organization.getName());
            ps.setString(2, organization.getCountry());
            ps.setBoolean(3, organization.getActive());
            return ps;
        }, keyHolder);
        long catId = keyHolder.getKey().longValue();
        return getOne(catId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM cats where id = ?", id);
    }

    @Override
    public Organization update(Long id, Organization organization) {
        jdbcTemplate.update("update cats set name = ?, color = ?, is_multi_color = ? where id = ?",
                organization.getName(), organization.getCountry(), organization.getActive(), id);
        return getOne(id);
    }
}
