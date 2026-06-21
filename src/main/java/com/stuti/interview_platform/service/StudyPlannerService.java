package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.QuestionEntity;
import com.stuti.interview_platform.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyPlannerService {

    private final QuestionRepository questionRepository;

    public StudyPlannerService(
            QuestionRepository questionRepository
    ){
        this.questionRepository =
                questionRepository;
    }

    public List<String> getTodayPlan(
            String weakestTopic
    ){

        return questionRepository
                .findByTopic(
                        weakestTopic
                )
                .stream()
                .limit(3)
                .map(
                        QuestionEntity::getTitle
                )
                .collect(
                        Collectors.toList()
                );
    }
}