package com.forumdev.demo.Service.ServiceInterface;


import com.forumdev.demo.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface
{
    List<User> findAll();
    String deleteById(Integer integer);
    User  saveAndFlush(User s);
    User SignUp(User s);
    User getByID(Integer id);
    User SignIn(User user);

}
