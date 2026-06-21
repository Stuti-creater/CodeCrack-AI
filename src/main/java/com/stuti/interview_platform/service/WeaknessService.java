package com.stuti.interview_platform.service;

import com.stuti.interview_platform.model.Question;
import com.stuti.interview_platform.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeaknessService {

    @Autowired
    private UserProgressRepository repository;

    @Autowired
    private QuestionService questionService;

    public String getWeakestTopic() {

        Map<String, Integer> topicCount =
                new HashMap<>();

        repository.findByUsernameAndSolvedTrue("stuti")
                .forEach(progress -> {

                    Question question =
                            questionService.getQuestion(
                                    progress.getQuestionName()
                            );

                    if (question != null) {

                        String topic =
                                question.getTopic();

                        topicCount.put(
                                topic,
                                topicCount.getOrDefault(
                                        topic,
                                        0
                                ) + 1
                        );
                    }
                });

        String[] allTopics = {
                "Arrays",
                "Binary Search",
                "Strings",
                "LinkedLists",
                "Stacks",
                "Queues",
                "Trees",
                "Graphs",
                "DP"
        };

        for (String topic : allTopics) {

            topicCount.putIfAbsent(
                    topic,
                    0
            );
        }

        return topicCount.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Arrays");
    }
}