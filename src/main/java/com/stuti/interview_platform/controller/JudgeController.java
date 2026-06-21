package com.stuti.interview_platform.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class JudgeController {

    @PostMapping("/judge")
    public String judge(){

        String actualOutput = "10";
        String expectedOutput = "10";

        if(actualOutput.equals(expectedOutput)){
            return "Accepted";
        }

        return "Wrong Answer";
    }
}