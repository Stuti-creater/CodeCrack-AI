package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

@Service
public class AiMentorService {

    public String review(
            String code
    ){

        if(code.contains("HashMap")){

            return """
                    AI Mentor

                    Good use of HashMap.

                    Time Complexity:
                    O(n)

                    Interview Score:
                    8/10
                    """;
        }

        if(code.contains("while")){

            return """
                    AI Mentor

                    Efficient iteration detected.

                    Interview Score:
                    7/10
                    """;
        }

        return """
                AI Mentor

                Solution works.

                Interview Score:
                6/10
                """;
    }
}