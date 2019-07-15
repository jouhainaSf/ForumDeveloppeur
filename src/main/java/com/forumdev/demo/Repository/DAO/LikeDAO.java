package com.forumdev.demo.Repository.DAO;

import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeDAO
{

    @Query("select l from Likes l where l.post=:id_p")
    Like fingByPost(@Param("id_p") Integer integer);

    Like liker(Post post);

}
