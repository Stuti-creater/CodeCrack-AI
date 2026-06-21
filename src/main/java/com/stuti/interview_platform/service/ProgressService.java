package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.RevisionSchedule;
import com.stuti.interview_platform.entity.UserProgress;
import com.stuti.interview_platform.repository.RevisionScheduleRepository;
import com.stuti.interview_platform.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProgressService {

    private final UserProgressRepository repository;

    private final RevisionScheduleRepository revisionRepository;

    public ProgressService(
            UserProgressRepository repository,

            RevisionScheduleRepository revisionRepository
    ) {

        this.repository = repository;

        this.revisionRepository =
                revisionRepository;
    }

    public void markSolved(
            String username,
            String questionName
    ) {

        UserProgress progress =
                repository
                        .findByUsernameAndQuestionName(
                                username,
                                questionName
                        )
                        .orElse(
                                new UserProgress(
                                        username,
                                        questionName,
                                        true
                                )
                        );

        progress.setSolved(true);

        repository.save(progress);

        RevisionSchedule revision =
                new RevisionSchedule();

        revision.setUsername(
                username
        );

        revision.setQuestionName(
                questionName
        );

        revision.setNextReviewDate(
                LocalDate.now()
        );

        revision.setReviewCount(
                0
        );

        revisionRepository.save(
                revision
        );
    }
}