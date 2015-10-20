package edu.mum.soaserver.repository;


import org.springframework.stereotype.Repository;

import edu.mum.soaserver.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{


}
