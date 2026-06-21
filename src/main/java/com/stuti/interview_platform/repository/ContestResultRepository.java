package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.ContestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestResultRepository
        extends JpaRepository<ContestResult, Long> {
}
