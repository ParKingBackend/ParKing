package com.example.clientservice.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId; // Primary key generated automatically
    private String username;
    private String password;
    private String email;
    @Column(nullable = true) // Make premiumId nullable
    private Long premiumId;

    // Constructors, getters, and setters

    public Client() {
        // Default constructor
    }

    public Client(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters for other attributes

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        this.password = password;//passwordEncoder.encode(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPremiumId(Long premiumId) {
        this.premiumId = premiumId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", premiumId='" + premiumId + '\'' +
                '}';
    }
}
