package com.forumdev.demo.Controlleur.ControlleurInterface;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserControlleurInterface
{
    User logIn(User user);
    List<User> allUsers();
    User addUser( User user);
    User updateUser(User user);
    String deleteUser(User user);
    void Comment(Comment comment);
    List<Like> HistoriqueLikes(User user);
    List<Dislike> HistoriqueDislikes( User user);
}
