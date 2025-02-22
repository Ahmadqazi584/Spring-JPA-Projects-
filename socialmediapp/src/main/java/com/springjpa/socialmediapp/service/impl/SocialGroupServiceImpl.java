package com.springjpa.socialmediapp.service.impl;

import com.springjpa.socialmediapp.exceptionhandler.ResourceNotFound;
import com.springjpa.socialmediapp.model.SocialGroup;
import com.springjpa.socialmediapp.repository.SocialGroupRepository;
import com.springjpa.socialmediapp.service.SocialGroupService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class SocialGroupServiceImpl implements SocialGroupService {

    @Autowired
    private SocialGroupRepository repository;

    @Override
    public Set<SocialGroup> getAllGroups() {
        Set<SocialGroup> socialGroupSet = new HashSet<>(repository.findAll());
        if (socialGroupSet.isEmpty()) throw new ResourceNotFound("no any group found!");
        return socialGroupSet;
    }

    @Override
    public SocialGroup getGroupById(long id) {
        SocialGroup socialGroup = repository.findById(id).orElseThrow(() -> new ResourceNotFound("no such group exists!"));
        return socialGroup;
    }

    @Override
    public SocialGroup insertGroup(SocialGroup group) {
        return repository.save(group);
    }

    @Override
    public SocialGroup updateGroup(SocialGroup group) {
        return repository.save(group);
    }

    @Override
    public SocialGroup deleteGroup(long id) {
        SocialGroup socialGroup = getGroupById(id);
        repository.deleteById(id);
        return socialGroup;
    }
}
