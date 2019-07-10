package com.forumdev.demo.Service;

import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getUserByEmailAndPwd( String email, String pwd) {
        return userRepository.getUserByEmailAndPwd(email, pwd);
    }
    public User getByID(Integer id)
    {
        return userRepository.findById(id).get();
    }
    public User save(User s) {
        return userRepository.save(s);
    }

    public User  saveAndFlush(User s) {
        return userRepository.saveAndFlush(s);
    }

    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }
}
