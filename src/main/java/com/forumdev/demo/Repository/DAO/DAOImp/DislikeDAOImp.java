package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.DislikeDAO;
import com.forumdev.demo.Repository.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DislikeDAOImp  implements DislikeDAO
{
    @Autowired
    private DislikeRepository dislikeRepository;

    @Override
    public Dislike addDislike(Post post) {
        Dislike dislike=new Dislike();
        dislike.setDislikes(0);
        dislike.setPost(post);
        return dislikeRepository.save(dislike);
    }

    @Override
    public Dislike getDislike(Integer integer)
    {
        return dislikeRepository.findById(integer).get();
    }
    @Override
    public Dislike Disliker(Post post)
    {
        Dislike dislike1 = findByPost(post);
        dislike1.setDislikes(dislike1.getDislikes()+1);
        return dislikeRepository.saveAndFlush(dislike1);
    }

    @Override
    public Dislike findByPost(Post post)
    {
       return dislikeRepository.fingByPost(post.getId_p());
    }
}
