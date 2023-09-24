package com.example.clientservice.service.request;

import lombok.Getter;

@Getter
public class ClientRegistrationRequest {
    private String username;
    private String password;
    private String email;
    private long premiumId;

    // Constructors, getters, and setters

    public ClientRegistrationRequest() {
        // Default constructor
    }

    public ClientRegistrationRequest(String username, String password, String email, long premiumId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.premiumId = premiumId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPremiumId(long premiumId) {
        this.premiumId = premiumId;
    }
}
