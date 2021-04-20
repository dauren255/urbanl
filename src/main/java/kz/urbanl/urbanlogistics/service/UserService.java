package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.CardData;
import kz.urbanl.urbanlogistics.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user) throws InternalException;

    List<User> getAllUsers() throws InternalException;

    User getUserById(Long id) throws InternalException;

    User updateUser(User user) throws InternalException;

    void deleteUser(User user) throws InternalException;

    User authenticate(String username, String password);

    User addCardData(Long userId, CardData cardData);
}
