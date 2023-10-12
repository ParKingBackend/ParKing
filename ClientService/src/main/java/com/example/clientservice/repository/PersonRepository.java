package com.example.clientservice.repository;

import com.example.clientservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);

    boolean existsById(Long id);

    void deleteById(Long id);
}
