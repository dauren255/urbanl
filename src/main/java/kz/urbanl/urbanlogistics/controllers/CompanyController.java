package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.service.impl.CompanyServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/company")
public class CompanyController extends CommonService {

    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCompanies(){
        return builder(success(companyService.getAllCompanies()));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCompany(@RequestBody Company company){
        return builder(success(companyService.createCompany(company)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCompany(@RequestBody Company company){
        return builder(success(companyService.updateCompany(company)));
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCompany(@RequestBody Company company){
        companyService.deleteCompany(company);
        return builder(success("Successfully deleted"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCompanyById(@PathVariable Long id){
        return builder(success(companyService.getCompanyById(id)));
    }
}
