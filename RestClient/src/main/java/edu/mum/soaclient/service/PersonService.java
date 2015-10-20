package edu.mum.soaclient.service;

import edu.mum.soa.Person;
import java.util.List;

/**
 *
 * @author bipin
 */
public interface PersonService {

    public Person findById(int id);
    
    public List<Person> findAll();
}
