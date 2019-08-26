package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.DAO.DAOImp.DislikeDAOImp;
import com.forumdev.demo.Repository.DAO.DislikeDAO;
import com.forumdev.demo.Service.ServiceInterface.DislikeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DislikeService implements DislikeServiceInterface
{
    @Autowired
    private DislikeDAO dislikeDAO;

    @Override
    public Dislike getDislike(Integer integer) {
        return dislikeDAO.getDislike(integer);
    }

    @Override
    public Dislike addDislike(Post post) {
        return dislikeDAO.addDislike(post);
    }

    @Override
    public Post Disliker(Post post ,String user) {
        return dislikeDAO.Disliker(post,user).getBody();
    }


}
