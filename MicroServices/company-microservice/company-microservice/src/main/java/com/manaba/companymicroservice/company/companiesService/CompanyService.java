package com.manaba.companymicroservice.company.companiesService;



import com.manaba.companymicroservice.company.companiesEntity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void createCompany(Company company);
    boolean updateCompany(Long id,Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
