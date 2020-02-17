package com.redflag.project.user;

import com.redflag.project.common.constants.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(ApiConstants.API_BASE + "user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    //TODO incomplete, needs to actually validate something, and be encrypted.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean validateUserLogin(UUID id, String password /* Temp, replaced with encrpyption */) {
        return this.userService.validateUser(id, password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserRequest userRequest) { return this.userService.createUser(userRequest);}
}
