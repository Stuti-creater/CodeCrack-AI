package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.RevisionSchedule;
import com.stuti.interview_platform.repository.RevisionScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RevisionService {

    private final RevisionScheduleRepository repository;

    public RevisionService(
            RevisionScheduleRepository repository
    ) {
        this.repository = repository;
    }

    public void scheduleRevision(
            String username,
            String questionName
    ) {

        RevisionSchedule revision =
                new RevisionSchedule();

        revision.setUsername(username);

        revision.setQuestionName(
                questionName
        );

        revision.setReviewCount(1);

        revision.setNextReviewDate(
                LocalDate.now().plusDays(1)
        );

        repository.save(revision);
    }
    public int getNextInterval(
        int reviewCount
){

    switch(reviewCount){

        case 1:
            return 3;

        case 2:
            return 7;

        case 3:
            return 14;

        default:
            return 30;

    }

}
}