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
    private UserDAOImp userDAOImp;


    @Override
    public List<User> findAll()
    {
        return userDAOImp.findAll();
    }
    @Override
    public User getUserByEmailPwd(User user)
    {

        return userDAOImp.logIn(user.getEmail(),user.getPwd());

    }
    @Override
    public User getByID(Integer id)
    {
        return userDAOImp.getUser(id);
    }
    @Override
    public ResponseEntity<User> save(User s)
    {

        if (s.getPwd().length()<8 )
        {
            logger.error("Mot de passe invalid !");
            return ResponseEntity.notFound().build();
        }
        else if (s.getPwd().indexOf(s.getFirstName())!=-1)
        {
            logger.error("Mot de passe ne peut pas contenir votre nom !");
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(userDAOImp.signIn(s));
        }

    }
    @Override
    public User  saveAndFlush(User s) {
        return userDAOImp.updateUser(s);
    }
    @Override
    public void deleteById(Integer integer) {
        userDAOImp.desabonne(integer);
    }
}
