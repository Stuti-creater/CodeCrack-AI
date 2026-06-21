package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

@Service
public class AiReviewService {

    public String review(String code){

        if(code.contains("while(left <= right)")){

            return """
✅ AI Review

Time Complexity: O(log n)

Space Complexity: O(1)

Strengths:
• Correct Binary Search approach
• Efficient implementation

Suggestions:
• Add comments for readability
• Handle edge cases clearly
""";

        }

        if(code.contains("for(")){

            return """
✅ AI Review

Likely Time Complexity: O(n)

Suggestions:
• Consider edge cases
• Improve variable naming
""";

        }

        return """
🤖 AI Review

Code submitted.

Unable to determine complexity.
""";
    }
}
