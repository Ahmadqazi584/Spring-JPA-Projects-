package com.springjpa.socialmediapp.service.impl;

import com.springjpa.socialmediapp.exceptionhandler.ResourceNotFound;
import com.springjpa.socialmediapp.model.SocialPost;
import com.springjpa.socialmediapp.repository.SocialPostRepository;
import com.springjpa.socialmediapp.service.SocialPostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SocialPostServiceImpl implements SocialPostService {

    @Autowired
    private SocialPostRepository repository;

    @Override
    public List<SocialPost> getAllPosts() {
        List<SocialPost> socialPostList = repository.findAll();
        if (socialPostList.isEmpty()) throw new ResourceNotFound("no any posts found!");
        return socialPostList;
    }

    @Override
    public SocialPost getPostById(long id) {
        SocialPost socialPost = repository.findById(id).orElseThrow(() -> new ResourceNotFound("no such post exists!"));
        return socialPost;
    }

    @Override
    public SocialPost insertPost(SocialPost post) {
        return repository.save(post);
    }

    @Override
    public SocialPost updatePost(SocialPost post) {
        return repository.save(post);
    }

    @Override
    public SocialPost deletePost(long id) {
        SocialPost socialPost = getPostById(id);
        repository.deleteById(id);
        return socialPost;
    }
}
