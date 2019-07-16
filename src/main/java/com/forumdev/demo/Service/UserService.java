package com.forumdev.demo.Service;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.DAOImp.UserDAOImp;
import com.forumdev.demo.Repository.DAO.UserDao;
import com.forumdev.demo.Service.ServiceInterface.UserServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServiceInterface
{
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDAOImp;


    @Override
    public List<User> findAll()
    {
        return userDAOImp.findAll();
    }
    @Override
    public User getUserByEmailPwd(User user)
    {

        return userDAOImp.logIn(user.getEmail(),user.getPwd()).getBody();

    }
    @Override
    public User getByID(Integer id)
    {
        return userDAOImp.getUser(id);
    }
    @Override
    public User save(User s)
    {
            return userDAOImp.signIn(s).getBody();
    }
    @Override
    public User  saveAndFlush(User s) {
        return userDAOImp.updateUser(s).getBody();
    }
    @Override
    public String deleteById(Integer integer) {
        return userDAOImp.desabonne(integer).getBody();
    }
}
