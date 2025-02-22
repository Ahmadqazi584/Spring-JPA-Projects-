package com.springjpa.socialmediapp.service.impl;

import com.springjpa.socialmediapp.exceptionhandler.ResourceNotFound;
import com.springjpa.socialmediapp.model.SocialProfile;
import com.springjpa.socialmediapp.repository.SocialProfileRepository;
import com.springjpa.socialmediapp.service.SocialProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SocialProfileServiceImpl implements SocialProfileService {

    @Autowired
    private SocialProfileRepository repository;

    @Override
    public SocialProfile getProfileById(long id) {
        SocialProfile socialProfile = repository.findById(id).orElseThrow(() -> new ResourceNotFound("this profile not exists!"));
        return socialProfile;
    }

    @Override
    public SocialProfile insertProfile(SocialProfile profile) {
        return repository.save(profile);
    }

    @Override
    public SocialProfile updateProfile(SocialProfile profile) {
        return repository.save(profile);
    }

    @Override
    public SocialProfile deleteProfile(long id) {
        SocialProfile profile = getProfileById(id);
        repository.deleteById(id);
        return profile;
    }
}
