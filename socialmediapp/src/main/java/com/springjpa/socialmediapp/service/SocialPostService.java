package com.springjpa.socialmediapp.service;

import com.springjpa.socialmediapp.model.SocialPost;
import com.springjpa.socialmediapp.model.SocialProfile;

import java.util.List;

public interface SocialPostService {

    List<SocialPost> getAllPosts();
    SocialPost getPostById(long id);
    SocialPost insertPost(SocialPost post);
    SocialPost updatePost(SocialPost post);
    SocialPost deletePost(long id);

}
