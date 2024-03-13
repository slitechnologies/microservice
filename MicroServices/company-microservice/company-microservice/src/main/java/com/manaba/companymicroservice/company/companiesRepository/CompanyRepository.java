package com.manaba.companymicroservice.company.companiesRepository;

import com.manaba.companymicroservice.company.companiesEntity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
