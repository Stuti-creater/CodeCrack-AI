package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.service.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import com.stuti.interview_platform.entity.InterviewHistory;

import com.stuti.interview_platform.repository.InterviewHistoryRepository;

@RestController
public class InterviewAIController {

    @Autowired
    private GroqService groqService;
    @Autowired
private InterviewHistoryRepository
        historyRepository;

    @PostMapping("/evaluate-interview")
    public String evaluateInterview(
        @RequestBody String answers,
        Principal principal
) {

        String prompt =

        "You are an expert FAANG interviewer. " +

        "Evaluate these interview answers. " +

        "Give scores out of 5 for Communication, " +

        "Technical Knowledge, Problem Solving, " +

        "and Confidence. Then provide overall " +

        "feedback and improvement suggestions.\n\n" +

        answers;

String feedback =

        groqService
                .getInterviewFeedback(
                        prompt
                );

InterviewHistory history =
        new InterviewHistory();

history.setUsername(
        principal.getName()
);

history.setCompany(
        "Mock Interview"
);

history.setFeedback(
        feedback
);

historyRepository.save(
        history
);

return feedback;
    }

}
