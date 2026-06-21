package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.RevisionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RevisionScheduleRepository
        extends JpaRepository<RevisionSchedule, Long> {

    List<RevisionSchedule>
    findByUsernameAndNextReviewDateLessThanEqual(
            String username,
            LocalDate date
    );
    void deleteByUsername(
        String username
);
}