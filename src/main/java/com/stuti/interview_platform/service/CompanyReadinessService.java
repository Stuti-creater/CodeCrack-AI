package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.UserProgress;
import com.stuti.interview_platform.model.Question;
import com.stuti.interview_platform.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CompanyReadinessService {

    @Autowired
    private UserProgressRepository repository;

    @Autowired
    private QuestionService questionService;

    public int getGoogleScore() {

        return calculateScore(
                Set.of(
                        "Arrays",
                        "Binary Search",
                        "DP",
                        "Graphs"
                )
        );
    }

    public int getAmazonScore() {

        return calculateScore(
                Set.of(
                        "Arrays",
                        "LinkedLists",
                        "Trees",
                        "Queues"
                )
        );
    }

    public int getMetaScore() {

        return calculateScore(
                Set.of(
                        "Trees",
                        "Graphs",
                        "DP",
                        "Strings"
                )
        );
    }

    private int calculateScore(
            Set<String> importantTopics
    ) {

        List<UserProgress> solvedQuestions =
                repository.findByUsernameAndSolvedTrue(
                        "stuti"
                );

        Set<String> masteredTopics =
                new HashSet<>();

        for(UserProgress progress : solvedQuestions){

            Question question =
                    questionService.getQuestion(
                            progress.getQuestionName()
                    );

            if(question != null){

                masteredTopics.add(
                        question.getTopic()
                );
            }
        }

        int matched = 0;

        for(String topic : importantTopics){

            if(masteredTopics.contains(topic)){

                matched++;
            }
        }

        return (matched * 100)
                / importantTopics.size();
    }
}