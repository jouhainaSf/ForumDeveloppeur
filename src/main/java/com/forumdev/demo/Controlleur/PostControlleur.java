package com.forumdev.demo.Controlleur;


import com.forumdev.demo.Controlleur.ControlleurInterface.PostControlleurInterface;
import com.forumdev.demo.Model.*;
import com.forumdev.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostControlleur implements PostControlleurInterface
{
    @Autowired
    private PostService postService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private DislikeService dislikeService;

    @Autowired
    private CommentService commentService;

    @Override
    @PostMapping(path = "/Poster" ,produces = "application/json")
    @ResponseBody
    public Post Poster(@RequestBody  Post post )
    {

        return postService.addPost(post);
    }

    @Override
    @PostMapping(path = "/PostByCategorie" , produces = "application/json" , consumes = "application/json")
    @ResponseBody
    public List<Post> getPostByCategorie(@RequestBody Categorie categorie)
    {

        return postService.findByCategorie(categorie);
    }

    @Override
    @PutMapping (path = "/modifyPost", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Post modifyPost(@RequestBody Post post)
    {

        return postService.updatePost(post);
    }

    @Override
    @DeleteMapping(path = "/DeletePost" , consumes = "application/json" )
    @ResponseBody
    public void deletePost(@RequestBody Post post)
    {
        postService.deletePost(post);
    }

    @Override
    @PostMapping(path = "/afficherPost" , consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Post afficherPost(@RequestBody Post post) {
        return postService.getOne(post.getId_p());
    }

    @PostMapping(path = "/liker", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Integer likePost(@RequestBody Like like)
    {
        return likeService.liker(like);
    }

    @PostMapping(path = "/disliker", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Integer dislikePost(@RequestBody Dislike dislike)
    {
        return dislikeService.Disliker(dislike);
    }

    @CrossOrigin
    @RequestMapping(path = "/posts" , produces="application/json" )
    public List<Post> allPosts()
    {
        return postService.getAllPosts();
    }

    @CrossOrigin
    @PostMapping(path = "/nbComment" , produces="application/json")
    public Integer nbComments(@RequestBody Post post)
    {
        return commentService.nbComment(post);
    }

    @CrossOrigin
    @PostMapping(path = "/getComments" )
    public List<Comment> getComments( @RequestBody  Post post)
    {
        return commentService.getComments(post);
    }

}
