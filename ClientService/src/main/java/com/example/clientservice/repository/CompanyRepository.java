package com.example.clientservice.repository;

import com.example.clientservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAll();

    Optional<Company> findById(Long id);

    Company save(Company company);

    boolean existsById(Long id);

    void deleteById(Long id);
}
