package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Controlleur.ControlleurInterface.UserControlleurInterface;
import com.forumdev.demo.Model.*;
import com.forumdev.demo.Service.CommentService;
import com.forumdev.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*" )
public class UserControlleur implements UserControlleurInterface
{
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Override
    @PostMapping(path = "/SignIn")
    @ResponseBody
    public User logIn(@RequestBody User user)
    {
        return userService.SignIn(user);
    }

    @Override
    @CrossOrigin
    @RequestMapping(path = "/users",produces = "application/json")
    public List<User> allUsers()
    {
        return userService.findAll();
    }

    @Override
    @CrossOrigin
    @PostMapping(path = "/SignUp" )
    public User addUser( @RequestBody User user)
    {
        return userService.SignUp(user);
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
    @ResponseBody
    public void Comment(@RequestBody  Comment comment )
    {
        commentService.save(comment);
    }

    @Override
    @PostMapping(path = "/historiqueLikes", consumes = "application/json",produces = "application/json")
    @ResponseBody
    public List<Like> HistoriqueLikes(@RequestBody User user) {
        return userService.historiqueLikes(user);
    }

    @Override
    @PostMapping(path = "/historiqueDislikes", consumes = "application/json",produces = "application/json")
    @ResponseBody
    public List<Dislike> HistoriqueDislikes(@RequestBody User user) {
        return userService.historiqueDislikes(user);
    }





}
