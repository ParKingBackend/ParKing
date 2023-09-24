package com.example.clientservice.repository;

import com.example.clientservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);

}
