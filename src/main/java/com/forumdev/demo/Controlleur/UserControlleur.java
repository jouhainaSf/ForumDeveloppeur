package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Service.CommentService;
import com.forumdev.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserControlleur
{
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/login",  consumes = "application/json", produces = "application/json")
    public User logIn( @RequestBody User user)
    {
        return  userService.getUserByEmailAndPwd(user.getEmail(), user.getPwd());
    }

    @RequestMapping("/users")
    public List<User> allUsers()
    {
        return userService.findAll();
    }
    @PostMapping(path = "/SignIn" , consumes = "application/json", produces = "application/json")
    public User addUser( @RequestBody User user)
    {
        return userService.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userService.saveAndFlush(user);
    }

    @DeleteMapping("/Delete")
    public void deleteUser(Integer id)
    {
        userService.deleteById(id);
    }

    @PostMapping(path = "/comment", consumes = "application/json", produces = "application/json")
    public void Comment(@RequestBody  Comment comment )
    {

        commentService.save(comment);
    }

}
