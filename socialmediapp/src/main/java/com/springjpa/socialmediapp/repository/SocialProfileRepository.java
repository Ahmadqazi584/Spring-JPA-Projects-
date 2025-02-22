package com.springjpa.socialmediapp.repository;

import com.springjpa.socialmediapp.model.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {
}
