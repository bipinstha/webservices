package edu.mum.soaclient.controller;

import edu.mum.soa.Person;
import edu.mum.soaclient.service.impl.PersonServiceImpl;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonServiceImpl personService;
//    private ProxyClient rmiClient;
//    public PersonController() {
//        try {
//            rmiClient = new ProxyClient();
//        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
//            java.util.logging.Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "Apple");
        map.put("b", "Ball");
        map.put("c", "Cat");
        model.addAttribute("map", map);
        return "Home";
    }

    @RequestMapping(value = {"/persons"}, method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Welcome find all!.");
        try {
            model.addAttribute("persons", this.personService.findAll());
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "PersonList";
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public String findOnePerson(@PathVariable Integer id, Model model, @ModelAttribute Person person) {
        logger.info("Welcome find by id!" + id);
        try {
            model.addAttribute("person", this.personService.findById(id));
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "PersonDetail";
    }

}
