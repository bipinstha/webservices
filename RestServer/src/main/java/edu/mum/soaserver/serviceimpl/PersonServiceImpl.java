package edu.mum.soaserver.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.soaserver.model.Person;
import edu.mum.soaserver.repository.PersonRepository;
import edu.mum.soaserver.service.PersonService;
import org.springframework.transaction.annotation.Transactional;

@Service
class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    @Transactional
    public void add(Person t) {
        if (t.getId() != null) {
            throw new IllegalArgumentException("Invalid data!");
        }
        this.repository.save(t);
    }

    @Override
    @Transactional
    public void update(Person t) {
        if (this.repository.findOne(t.getId()) == null) {
            throw new IllegalArgumentException("Invalid data!");
        }
        this.repository.save(t);
    }

    @Override
    public Person findOne(Integer obj) {
        return this.repository.findOne(obj);
    }

    @Override
    public List<Person> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional
    public void delete(Person t) {
        this.repository.delete(t);
    }

    @Override
    @Transactional
    public void deleteById(Integer obj) {
        this.repository.delete(obj);
    }

    @Override
    @Transactional
    public void deleteAll() {
        this.repository.deleteAll();
    }

}
