package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewQuestionService {

    public List<String> getQuestions(
        String company
){

    switch(company.toLowerCase()){

        case "google":

            return List.of(

                    "Explain Binary Search.",

                    "What is the time complexity of HashMap?",

                    "Solve Two Sum."

            );

        case "amazon":

            return List.of(

                    "Tell me about a conflict you handled.",

                    "Explain Merge Intervals.",

                    "How does DynamoDB work?"

            );

        case "meta":

            return List.of(

                    "Explain BFS vs DFS.",

                    "Design a News Feed System.",

                    "What is a HashSet?"

            );

        default:

            return List.of(

                    "Tell me about yourself.",

                    "What are your strengths?",

                    "Solve Binary Search."

            );

    }

}
}