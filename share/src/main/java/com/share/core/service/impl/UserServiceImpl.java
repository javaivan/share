package com.share.core.service.impl;

import com.share.core.model.User;
import com.share.core.repository.UserRepository;
import com.share.core.service.UserService;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String saveOrUpdate(User user){
        if(Objects.nonNull(user)){
            if(!Strings.isNullOrEmpty(user.getId())){
                User oldUser = getUserById(user.getId());
                if(Objects.nonNull(oldUser)){
                    oldUser.setLastName(user.getLastName());
                    oldUser.setFirstName(user.getFirstName());
                    return userRepository.save(oldUser).getId();
                }
                user.setId(null);
            }
            user.setRoles(Arrays.asList("USER"));
            return userRepository.save(user).getId();
        }
        return "";
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
