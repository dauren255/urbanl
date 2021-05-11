package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.CardData;
import kz.urbanl.urbanlogistics.model.Status;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.repository.CardDataRepo;
import kz.urbanl.urbanlogistics.repository.UserRepo;
import kz.urbanl.urbanlogistics.repository.UserRoleRepo;
import kz.urbanl.urbanlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public User getUserById(Long id) throws InternalException {
        return userRepo.findById(id).get();
    }

    @Override
    public User updateUser(User user) throws InternalException {
        User updateClient = userRepo.findById(user.getId()).get();
        return userRepo.saveAndFlush(updateClient);
    }

    @Override
    public void deleteUser(User user) throws InternalException {
        userRepo.delete(user);
    }

    @Override
    public User authenticate(String username, String password) {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User addCardData(Long userId, CardData cardData) {
        User user = userRepo.findById(userId).get();
        cardData.setUser(user);
//        user.getCardDataList().add(cardData);
        cardDataRepo.saveAndFlush(cardData);
        return userRepo.saveAndFlush(user);
    }
}
