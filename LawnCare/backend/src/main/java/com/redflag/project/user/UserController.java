package com.redflag.project.user;

import com.redflag.project.common.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.API_BASE + "user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public User find(UUID id) {
        return  userService.getUser(id);
    }

}
