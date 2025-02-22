package com.springjpa.socialmediapp.service;

import com.springjpa.socialmediapp.model.SocialGroup;

import java.util.Set;

public interface SocialGroupService {

    Set<SocialGroup> getAllGroups();
    SocialGroup getGroupById(long id);
    SocialGroup insertGroup(SocialGroup group);
    SocialGroup updateGroup(SocialGroup group);
    SocialGroup deleteGroup(long id);

}
