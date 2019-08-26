package com.forumdev.demo.Service.ServiceInterface;


import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.User;


import java.util.List;

public interface UserServiceInterface
{
    List<User> findAll();
    String deleteById(Integer integer);
    User  saveAndFlush(User s);
    User SignUp(User s);
    User getByID(Integer id);
    User SignIn(User user);
    List<Like> historiqueLikes(User user);
    List<Dislike> historiqueDislikes(User user);
    List<Comment> historiqueComment(User user);

}
