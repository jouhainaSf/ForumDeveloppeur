package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Repository.DAO.DislikeDAO;
import com.forumdev.demo.Repository.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DislikeDAOImp  implements DislikeDAO
{
    @Autowired
    private DislikeRepository dislikeRepository;

    public Dislike getDislike(Integer integer)
    {
        return dislikeRepository.findById(integer).get();
    }

    public Dislike addDislike(Dislike dislike)
    {
        return dislikeRepository.saveAndFlush(dislike);
    }
}
