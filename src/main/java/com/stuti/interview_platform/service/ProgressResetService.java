package com.stuti.interview_platform.service;

import com.stuti.interview_platform.repository.RevisionScheduleRepository;
import com.stuti.interview_platform.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgressResetService {

    private final UserProgressRepository
            progressRepository;

    private final RevisionScheduleRepository
            revisionRepository;

    public ProgressResetService(

            UserProgressRepository progressRepository,

            RevisionScheduleRepository revisionRepository
    ) {

        this.progressRepository =
                progressRepository;

        this.revisionRepository =
                revisionRepository;
    }

    public void resetProgress(
            String username
    ) {

        progressRepository
                .deleteByUsername(
                        username
                );

        revisionRepository
                .deleteByUsername(
                        username
                );
    }
}