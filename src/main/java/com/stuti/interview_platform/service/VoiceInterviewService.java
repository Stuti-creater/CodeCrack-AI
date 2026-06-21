package com.stuti.interview_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoiceInterviewService {

    @Autowired
    private GroqService groqService;

    public String generateQuestion(
            String company,
            String role,
            int questionNo
    ){

        String prompt = """
You are a senior interviewer at %s.

Interview Role:

%s

Question Number:

%d

Rules:

• Ask ONE interview question only.
• Do not number it.
• Don't explain.
• Don't give hints.
• Make it different every time.
• Return ONLY the question.

"""
.formatted(
company,
role,
questionNo
);

        return groqService.getInterviewFeedback(prompt);

    }

    public String generateFollowUp(

            String company,

            String role,

            String previousQuestion,

            String answer

    ){

        String prompt = """
You are interviewing a candidate.

Company:

%s

Role:

%s

Previous Question:

%s

Candidate Answer:

%s

Evaluate the answer silently.

Now ask ONE follow-up question naturally.

Return ONLY the question.

"""
.formatted(
company,
role,
previousQuestion,
answer
);

        return groqService.getInterviewFeedback(prompt);

    }
    public String generateInterviewReport(

        String company,

        String role,

        java.util.List<String> questions,

        java.util.List<String> answers

){

    StringBuilder history = new StringBuilder();

    for(int i=0;i<questions.size();i++){

        history.append("Question ")
                .append(i+1)
                .append(": ")
                .append(questions.get(i))
                .append("\n");

        if(i<answers.size()){

            history.append("Answer: ")
                    .append(answers.get(i))
                    .append("\n\n");

        }

    }

    String prompt = """
You are a senior FAANG interviewer.

Evaluate the complete interview.

Interview:

%s

Return exactly in this format.

⭐ Communication : x/10

⭐ Technical Knowledge : x/10

⭐ Confidence : x/10

⭐ Problem Solving : x/10

⭐ Fluency : x/10

⭐ Overall Score : xx/100

Strengths

•

•

•

Weaknesses

•

•

•

Improvement Suggestions

•

•

•

Final Verdict

""".formatted(history.toString());

    return groqService.getInterviewFeedback(prompt);

}

}