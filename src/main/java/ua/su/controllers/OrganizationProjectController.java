package ua.su.controllers;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController


@RequestMapping(value = "/OrganizationProject", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationProjectController {

    @GetMapping
    public String helloProject() {

        return "Hello from Organization Project";

    }
}
