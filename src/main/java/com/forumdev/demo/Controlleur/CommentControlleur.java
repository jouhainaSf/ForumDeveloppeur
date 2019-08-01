package com.forumdev.demo.Controlleur;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
public class CommentControlleur {

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/getComments", produces = "application/json")
    @ResponseBody
    public List<Comment> getComments(@RequestBody Post post) {
        return commentService.getComments(post);
    }

    @RequestMapping(path = "/AllComment", produces = "application/json")
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }

}

