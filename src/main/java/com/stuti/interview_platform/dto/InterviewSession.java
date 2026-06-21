package com.stuti.interview_platform.dto;

import java.util.ArrayList;
import java.util.List;

public class InterviewSession {

    private String company;

    private String role;

    private List<String> questions = new ArrayList<>();

    private List<String> answers = new ArrayList<>();

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }
}