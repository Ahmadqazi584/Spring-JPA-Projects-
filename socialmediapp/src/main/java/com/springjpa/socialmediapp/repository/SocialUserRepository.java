package com.springjpa.socialmediapp.repository;

import com.springjpa.socialmediapp.model.SocialUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
