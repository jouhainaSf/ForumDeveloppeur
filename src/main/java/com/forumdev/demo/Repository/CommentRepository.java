package com.forumdev.demo.Repository;

import com.forumdev.demo.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer>
{
}
