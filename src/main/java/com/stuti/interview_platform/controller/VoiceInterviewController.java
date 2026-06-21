package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.service.VoiceInterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.stuti.interview_platform.dto.InterviewSession;
import org.springframework.ui.Model;

@Controller
public class VoiceInterviewController {

    @Autowired
    private VoiceInterviewService service;
    private InterviewSession session =
        new InterviewSession();

    @GetMapping("/voice-interview")
    public String page() {

        return "voice-interview";

    }

    @PostMapping("/start-interview")
@ResponseBody
public String start(

@RequestParam String company,

@RequestParam String role

){

    session = new InterviewSession();

    session.setCompany(company);

    session.setRole(role);

    String question =

            service.generateQuestion(

                    company,

                    role,

                    1

            );

    session.addQuestion(question);

    return question;

}
    

    
    @PostMapping("/submit-answer")
@ResponseBody
public String submitAnswer(

@RequestParam String answer

){

    session.addAnswer(answer);

    String nextQuestion =

            service.generateFollowUp(

                    session.getCompany(),

                    session.getRole(),

                    session.getQuestions().get(

                            session.getQuestions().size()-1

                    ),

                    answer

            );

    session.addQuestion(

            nextQuestion

    );

    return nextQuestion;

}
@GetMapping("/finish-interview")
public String finishInterview(
        Model model
){

    String report =
            service.generateInterviewReport(

                    session.getCompany(),

                    session.getRole(),

                    session.getQuestions(),

                    session.getAnswers()

            );

    model.addAttribute(
            "report",
            report
    );

    return "interview-report";

}
}