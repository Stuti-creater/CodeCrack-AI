package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternWeaknessService {

    public List<String> getWeakPatterns(){

        return List.of(

                "Binary Search on Answer",

                "Sliding Window",

                "DFS"

        );

    }

}