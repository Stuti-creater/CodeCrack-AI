package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.entity.UserProgress;
import com.stuti.interview_platform.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProgressController {

    @Autowired
    private UserProgressRepository repository;

    @GetMapping("/submitQuestion")
public String submitQuestion(
        @RequestParam String username,
        @RequestParam String questionName
) {

    UserProgress progress =
            new UserProgress(
                    username,
                    questionName,
                    true
            );

    repository.save(progress);

return "Accepted";
        }
}

    