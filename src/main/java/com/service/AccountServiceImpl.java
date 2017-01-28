package com.service;

import com.dto.User;
import org.springframework.stereotype.Service;

/**
 * Created by Jayne on 1/27/2017.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public User createUser(User user){
        user.setUsername("enteredImpl");
        return user;
    }
}
