package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserDao
{

    List<User> findAll();
    ResponseEntity<User> signIn(User user);
    ResponseEntity<String> desabonne(Integer integer);
    User getUser(Integer integer);
    ResponseEntity<User> updateUser(User user);
    ResponseEntity<User> logIn(String email, String pwd);
    User dejaInscrit(String email);
    User afficherUser(User user);
}
