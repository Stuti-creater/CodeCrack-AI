package com.stuti.interview_platform.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GroqService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GroqService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getInterviewFeedback(String prompt) {

        String url = "https://api.groq.com/openai/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setBearerAuth(apiKey);

        Map<String, Object> body = new HashMap<>();

        body.put("model", "openai/gpt-oss-120b");

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> userMessage = new HashMap<>();

        userMessage.put("role", "user");

        userMessage.put("content", prompt);

        messages.add(userMessage);

        body.put("messages", messages);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                        url,
                        request,
                        Map.class
                );

        Map choice =
                (Map) ((List) response
                        .getBody()
                        .get("choices"))
                        .get(0);

        Map message =
                (Map) choice.get("message");

        return message.get("content").toString();
    }
    public String generateInterviewQuestion(

        String company,

        int questionNumber

){

    String prompt =

            "You are a senior "

            + company

            +

            " interviewer conducting a mock interview for a software engineer. "

            +

            "Generate ONE UNIQUE interview question. "

            +

            "Do NOT repeat commonly asked questions from previous interviews. "

            +

            "Question number: "

            +

            questionNumber

            +

            " of 3. ";

    if(questionNumber == 1){

        prompt +=

                "This must be a completely random opening question. "

                +

                "Sometimes ask DSA, sometimes behavioral, "

                +

                "sometimes OOP, sometimes system design.";

    }

    prompt +=

            "Return ONLY the interview question.";

    return getInterviewFeedback(
            prompt
    );
}
}