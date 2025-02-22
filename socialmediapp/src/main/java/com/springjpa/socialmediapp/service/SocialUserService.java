package com.springjpa.socialmediapp.service;

import com.springjpa.socialmediapp.model.SocialUser;
import java.util.List;

public interface SocialUserService {
    List<SocialUser> getAllUsers(); // Keeping List for user retrieval
    SocialUser getUserById(long id);
    SocialUser insertUser(SocialUser user);
    SocialUser updateUser(SocialUser user);
    SocialUser deleteUser(long id);
}
