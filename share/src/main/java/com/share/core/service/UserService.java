package com.share.core.service;

import com.share.core.model.User;
import java.util.List;

public interface UserService {
    String saveOrUpdate(User user);
    User getUserById(String userId);
    List<User> getAllUsers();
    User getUserByEmail(String email);
}
