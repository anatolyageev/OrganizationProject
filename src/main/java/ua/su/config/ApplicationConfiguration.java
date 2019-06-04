package ua.su.config;
/**
 * Created by Anatolii on 5/30/2019.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.su.repositories.OrganizationRepository;
import ua.su.repositories.impl.OrganizationRepositoryImpl;
import ua.su.repositories.impl.EmployeesRepositoryImpl;
import ua.su.services.EmployeesService;
import ua.su.services.OrganizationService;

@Configuration
public class ApplicationConfiguration {

}
