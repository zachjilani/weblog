package com.weblog.data.service;

import com.weblog.data.models.Company;
import com.weblog.data.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<Company> findAllCompanies(String stringFilter) {
    if (stringFilter == null || stringFilter.isEmpty()) {
      return companyRepository.findAll();
    } else {
      return companyRepository.search(stringFilter);
    }
  }

  public long countCompanies() {
    return companyRepository.count();
  }

  public void deleteCompany(Company c) {
    companyRepository.delete(c);
  }

  public void saveCompany(Company c) {
    if (c == null) {
      System.err.println("User is null. Are you sure you have connected your form to the application?");
      return;
    }
    companyRepository.save(c);
  }
}