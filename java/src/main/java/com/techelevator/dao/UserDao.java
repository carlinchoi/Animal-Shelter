package com.techelevator.dao;

import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    void updateUser(User user);

    User getUserByUsername(String username);

    void deleteUser(User username);

    void updateUserPassword(User databaseUser, RegisterUserDto user);

    boolean createPendingVolunteerUser(User volunteerPendingUser);

    List<User> findAllPendingVolunteers();

    List<User> findAllVolunteersAndAdmin();

    void updateUserApplicationStatus(int userId, String newStatus);

    void updateUserRole(int userId, String newRole);
}
