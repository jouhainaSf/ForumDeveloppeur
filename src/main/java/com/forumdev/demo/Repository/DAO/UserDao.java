package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao
{
    @Query("select u from User u where u.email=:email and u.pwd=:pwd")
    User getUserByEmailAndPwd(@Param("email") String email, @Param("pwd") String pwd);
}
