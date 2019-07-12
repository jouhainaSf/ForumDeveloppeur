package com.forumdev.demo.Service.ServiceInterface;


import com.forumdev.demo.Model.User;

import java.util.List;

public interface UserServiceInterface
{
    List<User> findAll();
    void deleteById(Integer integer);
    User  saveAndFlush(User s);
    User save(User s);
    User getByID(Integer id);
    User getUserByEmailAndPwd( String email, String pwd);

}
