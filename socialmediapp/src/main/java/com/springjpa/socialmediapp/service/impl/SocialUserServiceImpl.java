package com.springjpa.socialmediapp.service.impl;

import com.springjpa.socialmediapp.exceptionhandler.ResourceNotFound;
import com.springjpa.socialmediapp.model.SocialUser;
import com.springjpa.socialmediapp.repository.SocialUserRepository;
import com.springjpa.socialmediapp.service.SocialUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SocialUserServiceImpl implements SocialUserService {

    @Autowired
    private SocialUserRepository repository;

    @Override
    public List<SocialUser> getAllUsers() {
        List<SocialUser> socialUserList = repository.findAll();
        if (socialUserList.isEmpty()) throw new ResourceNotFound("no any users found!");
        return socialUserList;
    }

    @Override
    public SocialUser getUserById(long id) {
        SocialUser socialUser = repository.findById(id).orElseThrow(() -> new ResourceNotFound("no such user exists!"));
        return socialUser;
    }

    @Override
    public SocialUser insertUser(SocialUser user) {
        return repository.save(user);
    }

    @Override
    public SocialUser updateUser(SocialUser user) {
        return repository.save(user);
    }

    @Override
    public SocialUser deleteUser(long id) {
        SocialUser deleteUser = getUserById(id);
        repository.deleteById(id);
        return deleteUser;
    }
}
