package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>
{
    List<User> findAll();
    User save(User user);
    void deleteById(Integer integer);
    Optional<User> findById(Integer integer);
    User saveAndFlush(User user);

    @Query("select u from User u where u.email=:email and u.pwd=:pwd")
    User getUserByEmailAndPwd(@Param("email") String email, @Param("pwd") String pwd);

}
