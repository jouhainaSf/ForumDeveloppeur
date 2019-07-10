package com.forumdev.demo.Service;

import com.forumdev.demo.Model.Categorie;
import com.forumdev.demo.Model.Post;
import com.forumdev.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService
{
    @Autowired
    private PostRepository postRepository;

    public Post findByCategorie(Categorie categorie)
    {
        return postRepository.findByCategorie(categorie);
    }

    public Post getOne(Integer id)
    {
        return postRepository.findById(id).get();
    }

    public Post addLike(Post p)
    {
        p.setLikes(p.getLikes()+1);
        return postRepository.saveAndFlush(p);

    }

    public Post addDislike(Post p)
    {
        p.setLikes(p.getDislikes()+1);
        return postRepository.saveAndFlush(p);

    }

    public Post updateRate(Post p)
    {
        int like=p.getLikes();
        int dislike = p.getDislikes();
        int rate=like/(like+dislike);
        p.setRate(rate);
        return postRepository.saveAndFlush(p);
    }

    public Post updatePost(Post post)
    {
        return postRepository.saveAndFlush(post);
    }

    public Post addPost(Post post)
    {
        return postRepository.save(post);
    }


}
