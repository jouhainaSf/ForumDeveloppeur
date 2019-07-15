package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.UserDao;
import com.forumdev.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  class UserDAOImp implements UserDao
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User signIn(User user) {
        return userRepository.save(user);
    }

    @Override
    public void desabonne(Integer integer) {
        userRepository.deleteById(integer);

    }

    @Override
    public User getUser(Integer integer) {
        return userRepository.findById(integer).get();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User logIn(String email, String pwd) {
        return userRepository.getUserByEmailAndPwd(email,pwd);
    }


}
