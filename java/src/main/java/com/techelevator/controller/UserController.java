package com.techelevator.controller;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
@CrossOrigin

public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) {
        //this.pet = pet;
        this.userDao = userDao;
    }

    //(`/user/${userId}`)
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
        public User getUserById(@PathVariable("userId") int userId) {
            User user = userDao.getUserById(userId);
            return user;
        }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable("username") String username) {
        user = userDao.getUserByUsername(username);
        userDao.updateUser(user);
    }

}
