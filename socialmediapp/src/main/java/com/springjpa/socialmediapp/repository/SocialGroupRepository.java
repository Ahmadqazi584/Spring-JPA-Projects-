package com.springjpa.socialmediapp.repository;

import com.springjpa.socialmediapp.model.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {
}
