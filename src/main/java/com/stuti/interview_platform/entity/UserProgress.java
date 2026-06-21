package com.stuti.interview_platform.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class UserProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String questionName;

    private boolean solved;
    private LocalDate lastSolvedDate;
private int streak;

    public UserProgress() {
    }

    public UserProgress(String username,
                        String questionName,
                        boolean solved) {
        this.username = username;
        this.questionName = questionName;
        this.solved = solved;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getQuestionName() {
        return questionName;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public LocalDate getLastSolvedDate() {
    return lastSolvedDate;
}

public void setLastSolvedDate(
        LocalDate lastSolvedDate
) {
    this.lastSolvedDate = lastSolvedDate;
}

public int getStreak() {
    return streak;
}

public void setStreak(int streak) {
    this.streak = streak;
}
}