package com.springjpa.socialmediapp.controller;

import com.springjpa.socialmediapp.model.SocialUser;
import com.springjpa.socialmediapp.service.SocialGroupService;
import com.springjpa.socialmediapp.service.SocialPostService;
import com.springjpa.socialmediapp.service.SocialProfileService;
import com.springjpa.socialmediapp.service.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class SocialController {

    private SocialUserService socialUserService;
    private SocialProfileService socialProfileService;
    private SocialPostService socialPostService;
    private SocialGroupService socialGroupService;

    @Autowired
    public SocialController(SocialUserService socialUserService, SocialProfileService socialProfileService, SocialPostService socialPostService, SocialGroupService socialGroupService) {
        this.socialUserService = socialUserService;
        this.socialProfileService = socialProfileService;
        this.socialPostService = socialPostService;
        this.socialGroupService = socialGroupService;
    }

    @GetMapping
    public ResponseEntity<List<SocialUser>> getAllUsers() {
        List<SocialUser> socialUserList = socialUserService.getAllUsers();
        return new ResponseEntity<>(socialUserList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialUser> getUserById(@PathVariable long id) {
        SocialUser getSocialUser = socialUserService.getUserById(id);
        return new ResponseEntity<>(getSocialUser, HttpStatus.OK);
    }
}
