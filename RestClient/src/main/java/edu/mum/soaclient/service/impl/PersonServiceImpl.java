package edu.mum.soaclient.service.impl;

import edu.mum.soa.Person;
import edu.mum.soa.proxy.ProxyInterface;
import edu.mum.soa.proxy.jsp.JspProxyService;
import edu.mum.soaclient.service.PersonService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bipin
 */
@Service
public class PersonServiceImpl implements PersonService {

    private ProxyInterface client;

    public PersonServiceImpl() {
        this.client = new JspProxyService();
    }

    @Override
    public Person findById(int id) {
        System.out.println("Calling for findById method of proxy");
        return this.client.findById(id);
    }

    @Override
    public List<Person> findAll() {
        System.out.println("Calling for findAll method of proxy");
        return client.findAll();
    }

}
