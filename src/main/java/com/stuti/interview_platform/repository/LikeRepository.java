package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository
        extends JpaRepository<Like,Long>{

    boolean existsByPostIdAndUsername(

            Long postId,

            String username

    );

    long countByPostId(

            Long postId

    );

}