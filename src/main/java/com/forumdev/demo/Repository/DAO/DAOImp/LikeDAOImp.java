package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.LikeDAO;
import com.forumdev.demo.Repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeDAOImp implements LikeDAO
{
    @Autowired
    private LikesRepository likesRepository;

    public Like getLike(Integer integer)
    {
        return likesRepository.findById(integer).get();
    }

    public Like addLike(Like like)
    {
        return likesRepository.save(like);
    }

    @Override
    public Like fingByPost(Integer integer) {
        return fingByPost(integer);
    }

    @Override
    public Like liker(Post post) {

        Like like=fingByPost(post.getId_p());
        like.setLikes(like.getLikes()+1);
        return likesRepository.saveAndFlush(like);
    }
}
