package com.forumdev.demo.Controlleur.ControlleurInterface;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserControlleurInterface
{
    User logIn(User user);
    List<User> allUsers();
    ResponseEntity<User> addUser( User user);
    User updateUser(User user);
    void deleteUser(User user);
    void Comment(Comment comment);

}
