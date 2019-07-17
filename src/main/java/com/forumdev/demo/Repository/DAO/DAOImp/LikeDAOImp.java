package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.LikeDAO;
import com.forumdev.demo.Repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDAOImp implements LikeDAO
{
    @Autowired
    private LikesRepository likesRepository;

    @Override
    public Like getLike(Integer integer)
    {
        return likesRepository.findById(integer).get();
    }
    @Override
    public Like addLike(Post post)
    {
        Like like=new Like();
        like.setLikes(0);
        like.setPost(post);
        return likesRepository.save(like);
    }
    @Override
    public Like findByPost(Post post)
    {
        return likesRepository.fingByPost(post);
    }

    @Override
    public Like liker(Post post) {

        Like like=likesRepository.fingByPost(post);
        like.setLikes(like.getLikes()+1);
        return likesRepository.saveAndFlush(like);
    }
}
