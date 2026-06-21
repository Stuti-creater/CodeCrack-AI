package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository
        extends JpaRepository<Submission, Long> {

    List<Submission>
    findByUsernameOrderBySubmittedAtDesc(
            String username
    );
}