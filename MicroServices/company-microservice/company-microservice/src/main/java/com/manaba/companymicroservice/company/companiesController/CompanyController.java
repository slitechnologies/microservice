package com.manaba.companymicroservice.company.companiesController;


import com.manaba.companymicroservice.company.companiesEntity.Company;
import com.manaba.companymicroservice.company.companiesService.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PostMapping
    public ResponseEntity<String> CreateCompany(@RequestBody Company company){
        companyService.createCompany(company);
       return new ResponseEntity<>("Company Successfully Created", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable("id") Long id,
                                                @RequestBody Company company){
        companyService.updateCompany(id,company);
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company!=null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isCompanyDeleted = companyService.deleteCompanyById(id);
        if(isCompanyDeleted){
            return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
