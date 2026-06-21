package com.stuti.interview_platform.entity;

import jakarta.persistence.*;

@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String difficulty;

    private String company;

    private String topic;

    private String pattern;



    @Lob
private String description;

@Lob
private String example;

@Lob
private String starterCode;

@Lob
private String hint1;

@Lob
private String hint2;

@Lob
private String hint3;

    public QuestionEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getStarterCode() {
        return starterCode;
    }

    public void setStarterCode(String starterCode) {
        this.starterCode = starterCode;
    }
public String getHint1() {
    return hint1;
}

public void setHint1(String hint1) {
    this.hint1 = hint1;
}

public String getHint2() {
    return hint2;
}

public void setHint2(String hint2) {
    this.hint2 = hint2;
}

public String getHint3() {
    return hint3;
}

public void setHint3(String hint3) {
    this.hint3 = hint3;
}
public String getPattern() {
    return pattern;
}

public void setPattern(String pattern) {
    this.pattern = pattern;
}
    
}