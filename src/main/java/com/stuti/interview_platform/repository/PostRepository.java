package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository
        extends JpaRepository<Post,Long>{

    List<Post> findAllByOrderByCreatedAtDesc();

}