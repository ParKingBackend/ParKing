package com.example.clientservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key generated automatically
    private String firstName;
    private String surname;
    private String userName;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructors, getters, and setters

    public Person() {
        // Default constructor
    }

    public Person(String firstName, String surname, String userName) {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
    }

    // Getters and setters for other attributes

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}