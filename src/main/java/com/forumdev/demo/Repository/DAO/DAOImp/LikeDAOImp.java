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
    public Like findByPost(Integer integer)
    {
        return likesRepository.fingByPost(integer);
    }

    @Override
    public Like liker(Post post) {

        Like like=findByPost(post.getId_p());
        like.setLikes(like.getLikes()+1);
        return likesRepository.saveAndFlush(like);
    }
}
