package com.forumdev.demo.Controlleur.ControlleurInterface;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserControlleurInterface
{
    User logIn( User user);
    List<User> allUsers();
    User addUser( User user);
    User updateUser(User user);
    void deleteUser(Integer id);
    void Comment(Comment comment);

}
