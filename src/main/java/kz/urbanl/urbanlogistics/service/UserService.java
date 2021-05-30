package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.CardData;
import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user) throws InternalException;

    List<User> getAllUsers() throws InternalException;

    List<Mover> getAllMovers(String username) throws InternalException;

    Mover createMover(Mover mover) throws InternalException;

    User getUserById(Long id) throws InternalException;

    User updateUser(User user) throws InternalException;

    void deleteUser(User user) throws InternalException;

    User authenticate(String username, String password);

    Mover loadMoverByUsername(String username);

    CardData addCardData(Long userId, CardData cardData);
}
