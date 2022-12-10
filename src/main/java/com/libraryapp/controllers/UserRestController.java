package com.libraryapp.controllers;

import com.libraryapp.DAO.UserRepo1;
import com.libraryapp.DAO.UserRepository;
import com.libraryapp.entities.User;
import com.libraryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/employee")
public class UserRestController {
    @Autowired
    private UserService userService;

//    UserRestController(UserService userService){
//        this.userService = userService;
//    }
    @Autowired
    private UserRepo1 userRepo1;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userService.findById(id);
    }

//    @GetMapping("/id/{id}/userName/{userName}")
//    public User getUserByIdAndUserName(@PathVariable long id, @PathVariable String username){
//        return userService.getUserByIdAndUserName(id, username);
//    }

//    @GetMapping("/all1")
//    public List<User> getSomeUsers(){
//        return userService.getSomeUsers();
//    }
    @GetMapping("/all1")
    public List<User> getSomeUsers(){
        return userRepo1.someUsers();
    }
}
