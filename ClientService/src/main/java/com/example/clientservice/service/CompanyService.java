package com.example.clientservice.service;

import com.example.clientservice.model.Company;
import com.example.clientservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Company createCompany(Company company) {
        // Add validation or business logic here if needed
        return companyRepository.save(company);
    }

    public Optional<Company> updateCompany(Long id, Company updatedCompany) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company company = existingCompany.get();
            company.setCompName(updatedCompany.getCompName());
            company.setBio(updatedCompany.getBio());

            // You can update other fields here as well

            return Optional.of(companyRepository.save(company));
        }
        return Optional.empty();
    }

    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
