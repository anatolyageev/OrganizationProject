package ua.su.controllers;
/**
 * Created by User on 5/20/2019.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.su.domain.Organization;
import ua.su.services.OrganizationService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<Organization> getOrganization() {
        return organizationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Organization createCat(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @GetMapping(value = "/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return organizationService.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}
