package com.controllers;

import com.dto.User;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jayne on 1/27/2017.
 */

// RestController - meaning this class is ready for use by Spring MVC to handle web requests
// RestController combines @Controller and @ResponseBody
@RestController
public class Controller {

    @Autowired
    AccountService accountService;

    @RequestMapping("/testing")
    public String index() {
        return "TEST: Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public
    @ResponseBody
    String getRetrieveResource(
            @PathVariable(value = "name", required = false) String name
            ) {
        return "hello " + name;
    }

    ////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<?> postCreateResource(@RequestHeader("User-Agent") String userAgent,
                                                @RequestHeader(value = "Authorization", required = false) String auth
    ) {
        if(auth==null){
            return ResponseEntity.badRequest().build();
        }
        if(auth.equals("sofa")){
            return ResponseEntity.ok().build();
        }
        User user = new User(123, "John", "password123");
        User result = accountService.createUser(user);
        return new ResponseEntity<User>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public
    @ResponseBody
    String create(
            @RequestBody User user) {
        return "hello2 " + user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createMany")
    public ResponseEntity<List<User>> createManyUsers(
            @RequestBody List<User> users) {
        users.stream().forEach(u -> u.setUsername(u.getUsername() + "create"));
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    //////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<List<User>> deleteManyUsers(
            @RequestBody List<User> users) {
        users.stream().forEach(u -> u.setUsername(u.getUsername() + "delete"));
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }
}
