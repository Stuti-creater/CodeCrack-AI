package com.stuti.interview_platform.entity;

import jakarta.persistence.*;

@Entity
public class InterviewHistory {

    @Id
    @GeneratedValue(
            strategy =
            GenerationType.IDENTITY
    )
    private Long id;

    private String username;

    private String company;

    @Lob
    private String feedback;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username
    ) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(
            String company
    ) {
        this.company = company;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(
            String feedback
    ) {
        this.feedback = feedback;
    }
}