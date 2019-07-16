package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Controlleur.ControlleurInterface.UserControlleurInterface;
import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Service.CommentService;
import com.forumdev.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserControlleur implements UserControlleurInterface
{
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Override
    @PostMapping(path = "/login",  consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User logIn(@RequestBody User user)
    {

        return userService.getUserByEmailPwd(user);

    }

    @Override
    @RequestMapping("/users")
    public List<User> allUsers()
    {
        return userService.findAll();
    }

    @Override
    @PostMapping(path = "/SignIn" , consumes = "application/json", produces = "application/json")
    public User addUser( @RequestBody User user)
    {
        return userService.save(user);
    }

    @Override
    @PutMapping("/update")
    public User updateUser(@RequestBody User user)
    {
        return userService.saveAndFlush(user);
    }

    @Override
    @DeleteMapping(path = "/Delete" , consumes = "application/json",produces = "application/json")
    @ResponseBody
    public String deleteUser(@RequestBody  User user)
    {
        return userService.deleteById(user.getId_u());
    }
    @Override
    @PostMapping(path = "/comment", consumes = "application/json", produces = "application/json")
    public void Comment(@RequestBody  Comment comment )
    {

        commentService.save(comment);
    }

}
