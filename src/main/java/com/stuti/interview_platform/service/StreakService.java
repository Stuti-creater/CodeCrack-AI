package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class StreakService {

    public int updateStreak(
            LocalDate lastSolvedDate,
            int currentStreak
    ){

        LocalDate today =
                LocalDate.now();

        if(lastSolvedDate == null){
            return 1;
        }

        long days =
                ChronoUnit.DAYS.between(
                        lastSolvedDate,
                        today
                );

        if(days == 0){
            return currentStreak;
        }

        if(days == 1){
            return currentStreak + 1;
        }

        return 1;
    }
}
