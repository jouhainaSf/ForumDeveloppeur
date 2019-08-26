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
    @PostMapping(path = "/Poster" ,produces = "application/json",consumes="application/json")
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
    @PostMapping (path = "/modifyPost", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public Post modifyPost(@RequestBody Post post)
    {

        return postService.updatePost(post);
    }

    @Override
    @PostMapping(path = "/DeletePost" , consumes = "application/json" , produces = "application/json")
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

    @CrossOrigin
    @PostMapping(path = "/liker/{id_u:.+}")
    public Post likePost(@RequestBody Post post ,@PathVariable String id_u)
    {
        return likeService.liker(post , id_u);
    }

    @PostMapping(path = "/disliker/{id_u:.+}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Post dislikePost(@RequestBody Post post ,@PathVariable String id_u)
    {
        return dislikeService.Disliker(post,id_u);
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
    @PostMapping(path = "/findByUser" , produces="application/json" , consumes = "application/json")
    @ResponseBody
    public List<Post> findByUser (@RequestBody User user)
    {
        return postService.findByUser(user);
    }




}
