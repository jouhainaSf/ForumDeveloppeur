package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.DAO.UserDao;
import com.forumdev.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  class UserDAOImp  implements UserDao
{
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);

    }

    public Optional<User> findById(Integer integer) {
        return userRepository.findById(integer);
    }

    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserByEmailAndPwd(String email , String pwd)
    {
        return getUserByEmailAndPwd(email,pwd);
    }

}
