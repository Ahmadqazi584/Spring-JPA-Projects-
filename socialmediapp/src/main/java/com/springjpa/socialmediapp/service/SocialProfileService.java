package com.springjpa.socialmediapp.service;

import com.springjpa.socialmediapp.model.SocialProfile;

import java.util.List;

public interface SocialProfileService {

    SocialProfile getProfileById(long id);
    SocialProfile insertProfile(SocialProfile profile);
    SocialProfile updateProfile(SocialProfile profile);
    SocialProfile deleteProfile(long id);

}
