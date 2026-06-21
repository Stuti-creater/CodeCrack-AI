
package com.stuti.interview_platform.model;

public class Question {

    private String title;
    private String difficulty;
    private String company;
    private String description;
    private String example;
    private String starterCode;
    private String hint;
    private String topic;

    public Question(
            String title,
            String difficulty,
            String company,
            String description,
            String example,
            String starterCode,
            String hint,
            String topic
    ) {

        this.title = title;
        this.difficulty = difficulty;
        this.company = company;
        this.description = description;
        this.example = example;
        this.starterCode = starterCode;
        this.hint = hint;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }

    public String getStarterCode() {
        return starterCode;
    }

    public String getHint() {
        return hint;
    }

    public String getTopic() {
    return topic;
}
}

