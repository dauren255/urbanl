package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.repository.MoverRepo;
import kz.urbanl.urbanlogistics.repository.UserRoleRepo;
import kz.urbanl.urbanlogistics.service.MoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoverServiceImpl implements MoverService {

    @Autowired
    MoverRepo moverRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Autowired
    CompanyServiceImpl companyService;

    @Autowired
    UserServiceImpl userService;

    @Override
    public void addMoverToCompany(Long companyId, Mover mover) throws InternalException {
        Company company = companyService.getCompanyById(companyId);
        mover.setCompany(company);
        moverRepo.saveAndFlush(mover);
    }


    @Override
    public List<Mover> getAllMovers(String username) throws InternalException {
        return moverRepo.findAllByCompany(userService.getUserByUsername(username).getCompany());
    }

    @Override
    public Mover createMover(Mover mover, String username) throws InternalException {
        User user = userService.getUserByUsername(username);
        user.getRoles().add(userRoleRepo.findById(4L).get());
        user.setCompany(userService.getUserByUsername(username).getCompany());
        userService.createUser(user);
        mover.setUser(user);
        mover.setCompany(userService.getUserByUsername(username).getCompany());
        return moverRepo.saveAndFlush(mover);
    }


    @Override
    public Mover updateMover(Mover mover, String username) throws InternalException {
        Mover updateClient = moverRepo.findById(mover.getId()).get();
        updateClient.setCarData(mover.getCarData());
        updateClient.setCarName(mover.getCarName());
        updateClient.setCarNumber(mover.getCarNumber());
        updateClient.setDriverLicense(mover.getDriverLicense());
        return moverRepo.saveAndFlush(updateClient);
    }
}
