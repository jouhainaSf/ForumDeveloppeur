package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Repository.DAO.DAOImp.DislikeDAOImp;
import com.forumdev.demo.Service.ServiceInterface.DislikeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class DislikeService implements DislikeServiceInterface
{
    @Autowired
    private DislikeDAOImp dislikeDAOImp;

    @Override
    public Dislike getDislike(Integer integer) {
        return dislikeDAOImp.getDislike(integer);
    }

    @Override
    public Dislike addDislike(Dislike dislike) {
        return dislikeDAOImp.addDislike(dislike);
    }
}
