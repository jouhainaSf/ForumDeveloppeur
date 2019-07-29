package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.UserDao;
import com.forumdev.demo.Service.ServiceInterface.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDAO;

    @Override
    public List<User> findAll()
    {
        return userDAO.findAll();
    }
    @Override
    public User SignIn(User user)
    {
        return userDAO.logIn(user.getEmail(),user.getPwd()).getBody();
    }

    @Override
    public List<Like> historiqueLikes(User user) {
        return userDAO.historiqueLikes(user);
    }

    @Override
    public List<Dislike> historiqueDislikes(User user) {
        return userDAO.historiqueDislike(user);
    }


    @Override
    public User getByID(Integer id)
    {
        return userDAO.getUser(id);
    }
    @Override
    public User SignUp(User s)
    {
            return userDAO.signUp(s).getBody();
    }
    @Override
    public User  saveAndFlush(User s) {
        return userDAO.updateUser(s).getBody();
    }
    @Override
    public String deleteById(Integer integer) {
        return userDAO.desabonne(integer).getBody();
    }




}
