package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.model.User;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company) throws InternalException;

    List<Company> getAllCompanies() throws InternalException;

    Company getCompanyById(Long id) throws InternalException;

    Company updateCompany(Company company) throws InternalException;

    void deleteCompany(Company company) throws InternalException;

    void addMoverToCompany(Long companyId, Mover mover) throws InternalException;
}
