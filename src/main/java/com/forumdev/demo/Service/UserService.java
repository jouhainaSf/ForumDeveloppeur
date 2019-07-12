package com.forumdev.demo.Service;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.DAOImp.UserDAOImp;
import com.forumdev.demo.Service.ServiceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServiceInterface
{
    @Autowired
    private UserDAOImp userDAOImp;

    @Override
    public List<User> findAll()
    {
        return userDAOImp.findAll();
    }
    @Override
    public User getUserByEmailAndPwd( String email, String pwd)
    {
        return userDAOImp.getUserByEmailAndPwd(email, pwd);
    }
    @Override
    public User getByID(Integer id)
    {
        return userDAOImp.findById(id).get();
    }
    @Override
    public User save(User s) {
        return userDAOImp.save(s);
    }
    @Override
    public User  saveAndFlush(User s) {
        return userDAOImp.saveAndFlush(s);
    }
    @Override
    public void deleteById(Integer integer) {
        userDAOImp.deleteById(integer);
    }
}
