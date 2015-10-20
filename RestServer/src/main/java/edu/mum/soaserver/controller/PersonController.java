package edu.mum.soaserver.controller;

import edu.mum.soaserver.model.Person;
import edu.mum.soaserver.model.PersonList;
import edu.mum.soaserver.service.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    /**
     * Simply selects the home view to render by returning its name.
     *
     * @param person
     * @param student
     */
    @RequestMapping(value = "/person/add", method = RequestMethod.POST,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void addPerson(@RequestBody Person person) {
        System.out.println(person);
        try {
            this.personService.add(person);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }

    }

    @RequestMapping(value = "/person/update", method = RequestMethod.POST,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public void updatePerson(@RequestBody Person person) {
        System.out.println(person);
        try {
            this.personService.update(person);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }

    }

    @RequestMapping(value = "/person/put", method = RequestMethod.PUT,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Person putSample(@RequestBody Person person) {
        System.out.println(person);
        try {
            this.personService.add(person);
            return person;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @RequestMapping(value = "/person/delete", method = RequestMethod.DELETE,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Person deleteSample(@RequestBody Person person) {
        System.out.println(person);
        return person;
    }

    @RequestMapping(value = {"/", "/person/list"}, method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    PersonList findAllPerson() {
        System.out.println("Service method findAllPerson called from client.");
        PersonList list = new PersonList(this.personService.findAll());
        return list;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json", 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Person findPerson(@PathVariable Integer id) {
        try {
            System.out.println("Service method findPerson called from client.");
            return this.personService.findOne(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}
