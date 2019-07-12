package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>
{
    List<User> findAll();
    User save(User user);
    void deleteById(Integer integer);
    Optional<User> findById(Integer integer);
    User saveAndFlush(User user);
}
