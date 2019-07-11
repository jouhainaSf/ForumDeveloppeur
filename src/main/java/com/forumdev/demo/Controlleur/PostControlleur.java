package com.forumdev.demo.Controlleur;


import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Image;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Service.CategorieService;
import com.forumdev.demo.Service.ImageService;
import com.forumdev.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostControlleur
{
    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CategorieService categorieService;


    @PostMapping(path = "/Poster" ,produces = "application/json")
    @ResponseBody
    public Post Poster(Post post , @RequestParam("img") String image)
    {

        Image image1=new Image();
        image1.setPath(image);
        Post p=new Post();
        p.setCategorie(post.getCategorie());
        p.setDescription(post.getDescription());
        p.setUser(post.getUser());
        p.setTitle(post.getTitle());
        p =postService.addPost(post);
        image1.setPost(p);
        imageService.uploadImage(image1);
        return p;
    }

    @PostMapping(path = "/PostByCategorie" , produces = "application/json" , consumes = "application/json")
    @ResponseBody
    public Categorie  getPostByCategorie(@RequestBody Categorie categorie)
    {

        return categorieService.FindOne(1);
    }

    @PostMapping(path = "/addLike",produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Post addLike(@RequestBody Post P)
    {
        Post pp= postService.getOne(P.getId_p());
        pp= postService.addLike(pp);
        return postService.updateRate(pp);
    }

    @PostMapping(path = "/addDislike",produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Post addDislike(@RequestBody Post P)
    {
        Post pp= postService.getOne(P.getId_p());
        pp= postService.addDislike(pp);
        return postService.updateRate(pp);
    }


    @PutMapping (path = "/modifyPost", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Post modifyPost(@RequestBody Post post)
    {
        Post post1=postService.getOne(post.getId_p());
        post1.setDescription(post.getDescription());
        return postService.updatePost(post1);
    }

    @DeleteMapping(path = "/DeletePost" , consumes = "application/json" )
    @ResponseBody
    public void deletePost(@RequestBody Post post)
    {
        postService.deletePost(post);
    }





}
