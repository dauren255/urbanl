package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.repository.CompanyRepo;
import kz.urbanl.urbanlogistics.repository.MoverRepo;
import kz.urbanl.urbanlogistics.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private MoverRepo moverRepo;

    @Override
    public Company createCompany(Company company) throws InternalException {
        return companyRepo.saveAndFlush(company);
    }

    @Override
    public List<Company> getAllCompanies() throws InternalException {
        return companyRepo.findAll();
    }

    @Override
    public Company getCompanyById(Long id) throws InternalException {
        return companyRepo.findById(id).get();
    }

    @Override
    public Company updateCompany(Company company) throws InternalException {
        Company updateCompany = companyRepo.findById(company.getId()).get();
        updateCompany.setName(company.getName());
        return companyRepo.saveAndFlush(updateCompany);
    }

    @Override
    public void deleteCompany(Company company) throws InternalException {
        companyRepo.delete(companyRepo.findById(company.getId()).get());
    }

    @Override
    public void addMoverToCompany(Long companyId, Mover mover) throws InternalException {
        Company company = companyRepo.findById(companyId).get();
        company.getMovers().add(mover);
        companyRepo.save(company);
    }
}
