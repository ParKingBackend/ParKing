package com.example.clientservice.web.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.Person;
import com.example.clientservice.service.ClientService;
import com.example.clientservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    private final ClientService clientService;

    private final ClientService clientRepository;
    @Autowired
    public PersonController(PersonService personService, ClientService clientService, ClientService clientRepository) {
        this.personService = personService;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/get/all")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/create/{clientId}")
    public ResponseEntity<Object> createPerson(@PathVariable Long clientId, @RequestBody Person person) {
        Optional<Client> optionalClient = Optional.ofNullable(clientRepository.findById(clientId));
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            person.setClient(client);

            Person createdPerson = personService.createPerson(person);

            return ResponseEntity.ok(createdPerson);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Client with ID " + clientId + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }

    @PutMapping("/edit/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
