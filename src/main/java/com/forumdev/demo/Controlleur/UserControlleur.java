package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Controlleur.ControlleurInterface.UserControlleurInterface;
import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.DAOImp.UserDAOImp;
import com.forumdev.demo.Service.CommentService;
import com.forumdev.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserControlleur implements UserControlleurInterface
{
    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserDAOImp userDAOImp;



    @Override
    @PostMapping(path = "/SignIn",  consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User logIn(@RequestBody User user)
    {
        return userService.SignIn(user);
    }

    @Override
    @RequestMapping("/users")
    public List<User> allUsers()
    {
        return userService.findAll();
    }


    @RequestMapping("/typelist")
    public List<String> typeList()
    {
        return userService.findAll().get(0).getTypeList();
    }

    @RequestMapping("/userdet")
    @ResponseBody
    public UserDetails userDetails(@RequestBody String s)
    {
        return userDAOImp.loadUserByUsername(s);
    }

    @Override
    @PostMapping(path = "/SignUp" , consumes = "application/json", produces = "application/json")
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
