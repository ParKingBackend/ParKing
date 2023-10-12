package com.example.clientservice.service;

import com.example.clientservice.model.Person;
import com.example.clientservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return (Person) personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        if (personRepository.existsById(id)) {
            updatedPerson.setId(id);
            return personRepository.save(updatedPerson);
        }
        return null;
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
