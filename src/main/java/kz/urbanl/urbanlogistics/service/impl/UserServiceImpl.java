package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.*;
import kz.urbanl.urbanlogistics.repository.*;
import kz.urbanl.urbanlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MoverRepo moverRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private CardDataRepo cardDataRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) throws InternalException {
        user.setStatus(Status.ACTIVE);
        user.setRoles(Collections.singletonList(userRoleRepo.findById(2L).get()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() throws InternalException {
        return userRepo.findAll();
    }

    @Override
    public List<Mover> getAllMovers(String username) throws InternalException {
        return moverRepo.findAllByCompany(userRepo.findByUsernameIgnoreCase(username).getCompany());
    }

    @Override
    public Mover createMover(Mover mover) throws InternalException{
        return moverRepo.saveAndFlush(mover);
    }

    @Override
    public User getUserById(Long id) throws InternalException {
        return userRepo.findById(id).get();
    }

    @Override
    public User updateUser(User user) throws InternalException {
        User updateClient = userRepo.findByUsernameIgnoreCase(user.getUsername());
        updateClient.setName(user.getName());
        updateClient.setSurname(user.getSurname());
        updateClient.setEmail(user.getEmail());
        updateClient.setPhoneNumber(user.getPhoneNumber());
        return userRepo.saveAndFlush(updateClient);
    }

    @Override
    public void deleteUser(User user) throws InternalException {
        User newUser = userRepo.findByUsernameIgnoreCase(user.getUsername());
        userRepo.delete(newUser);
    }

    @Override
    public User authenticate(String username, String password) {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameIgnoreCase(username);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public Mover loadMoverByUsername(String username) {
        Mover mover = moverRepo.findByUsernameIgnoreCase(username);
        if (mover == null) {
            return null;
        }
        return mover;
    }
    @Override
    public CardData addCardData(Long userId, CardData cardData) {
        User user = userRepo.findById(userId).get();
        cardData.setUser(user);
//        user.getCardDataList().add(cardData);
        return cardDataRepo.saveAndFlush(cardData);
    }
}
