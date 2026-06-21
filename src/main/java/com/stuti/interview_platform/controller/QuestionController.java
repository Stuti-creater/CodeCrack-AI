
package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.entity.QuestionEntity;
import com.stuti.interview_platform.model.Question;
import com.stuti.interview_platform.repository.QuestionRepository;
import com.stuti.interview_platform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {  

    @Autowired
    private QuestionService questionService;

    @Autowired
private QuestionRepository questionRepository;

    @GetMapping("/question")
    public String questionPage(
            @RequestParam String name,
            Model model
    ) {

        QuestionEntity question =
        questionRepository
                .findByTitle(name)
                .orElseThrow();
                boolean needsInput =
        question.getStarterCode()
                .contains("Scanner");

model.addAttribute(
        "needsInput",
        needsInput
);

        model.addAttribute(
                "questionName",
                question.getTitle()
        );

        model.addAttribute(
                "difficulty",
                question.getDifficulty()
        );

        model.addAttribute(
                "company",
                question.getCompany()
        );

        model.addAttribute(
                "description",
                question.getDescription()
        );

        model.addAttribute(
                "example",
                question.getExample()
        );

        model.addAttribute(
                "starterCode",
                question.getStarterCode()
        );

        model.addAttribute(
    "hint",
    question.getHint1()
);

        return "question";
    }
}

