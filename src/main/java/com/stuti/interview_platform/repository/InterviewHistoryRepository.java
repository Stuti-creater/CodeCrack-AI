package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.InterviewHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewHistoryRepository
        extends JpaRepository<
        InterviewHistory,
        Long
        > {

    List<InterviewHistory>
    findByUsernameOrderByIdDesc(
            String username
    );

}