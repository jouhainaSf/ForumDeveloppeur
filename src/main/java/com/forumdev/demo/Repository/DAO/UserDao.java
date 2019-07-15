package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDao   {

    List<User> findAll();
    User signIn(User user);
    void desabonne(Integer integer);
    User getUser(Integer integer);
    User updateUser(User user);
    User logIn(String email, String pwd);
}
