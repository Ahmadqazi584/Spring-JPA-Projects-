package com.springjpa.socialmediapp.repository;

import com.springjpa.socialmediapp.model.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialPostRepository extends JpaRepository<SocialPost, Long> {
}
