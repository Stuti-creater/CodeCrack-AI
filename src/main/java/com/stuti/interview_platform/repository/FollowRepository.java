package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository
        extends JpaRepository<Follow, Long> {

    List<Follow> findByFollower(String follower);

    List<Follow> findByFollowing(String following);

    boolean existsByFollowerAndFollowing(
            String follower,
            String following
    );

    long countByFollower(String follower);

    long countByFollowing(String following);

}