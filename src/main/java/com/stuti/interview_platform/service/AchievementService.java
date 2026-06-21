package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {

    public String getAchievement(long solved){

        if(solved >= 50)
            return "🥇 DSA Master";

        if(solved >= 25)
            return "🥈 Advanced Solver";

        if(solved >= 10)
            return "🥉 Problem Solver";

        if(solved >= 1)
            return "🎯 First Accepted";

        return "🚀 Start Coding";
    }

    public List<String> getBadges(
            long solvedCount
    ) {

        List<String> badges =
                new ArrayList<>();

        if(solvedCount >= 1){
            badges.add("🥉 First Solve");
        }

        if(solvedCount >= 5){
            badges.add("🔥 5 Solves");
        }

        if(solvedCount >= 10){
            badges.add("⚡ 10 Solves");
        }

        if(solvedCount >= 25){
            badges.add("🏆 25 Solves");
        }

        return badges;
    }
}