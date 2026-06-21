package com.stuti.interview_platform.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.stuti.interview_platform.entity.Submission;
import com.stuti.interview_platform.model.RunRequest;
import com.stuti.interview_platform.service.MainGeneratorService;
import com.stuti.interview_platform.service.AiMentorService;
import com.stuti.interview_platform.service.AiReviewService;
import com.stuti.interview_platform.service.JudgeService;
import com.stuti.interview_platform.repository.SubmissionRepository;
import com.stuti.interview_platform.service.ProgressService;
import com.stuti.interview_platform.service.AiMentorService;
import org.springframework.web.bind.annotation.*;
import com.stuti.interview_platform.service.RevisionService;
import com.stuti.interview_platform.service.XPService;
import com.stuti.interview_platform.repository.UserRepository;
import com.stuti.interview_platform.entity.User;


@RestController
public class RunController {
    private final MainGeneratorService mainGeneratorService;
    private final JudgeService judgeService;
    private final AiReviewService aiReviewService;
    private final SubmissionRepository submissionRepository;
    private final ProgressService progressService;
    private final AiMentorService aiMentorService;
    private final RevisionService revisionService;
private final XPService xpService;
private final UserRepository userRepository;

public RunController(
        MainGeneratorService mainGeneratorService,
        JudgeService judgeService,
        AiReviewService aiReviewService,
        SubmissionRepository submissionRepository,
        ProgressService progressService,
        AiMentorService aiMentorService,
        RevisionService revisionService,
XPService xpService,
UserRepository userRepository
) {
    this.mainGeneratorService =
            mainGeneratorService;

    this.judgeService =
            judgeService;

            this.aiReviewService =
        aiReviewService;

        this.submissionRepository =
        submissionRepository;

        this.progressService =
        progressService;

        this.aiMentorService =
        aiMentorService;

        this.revisionService =
        revisionService;

this.xpService =
        xpService;

this.userRepository =
        userRepository;
}

    @PostMapping("/run")
public String runCode(
        @RequestBody RunRequest request
) {
    String code = request.getCode();
String input = request.getInput();
String questionTitle =
        request.getQuestionTitle();

    try {

        String finalCode;

if(code.contains("class Solution")){

    finalCode =
            code +
            "\n" +
            mainGeneratorService
        .generateBinarySearchMain(
                new int[]{
                        -1,0,3,5,9,12
                },
                9
        );

}
else{

    finalCode = code;

}

java.nio.file.Files.writeString(
        java.nio.file.Path.of("Main.java"),
        finalCode
);

        Process compile =
                new ProcessBuilder(
                        "javac",
                        "Main.java"
                ).start();
                

        compile.waitFor();

        if(compile.exitValue() != 0){

    BufferedReader errorReader =
            new BufferedReader(
                    new InputStreamReader(
                            compile.getErrorStream()
                    )
            );

    StringBuilder errors =
            new StringBuilder();

    String line;

    while((line = errorReader.readLine()) != null){

        errors.append(line)
              .append("\n");

    }

    return errors.toString();

}

        Process run =
        new ProcessBuilder(
                "java",
                "Main"
        ).start();
        run.getOutputStream()
        .write(input.getBytes());

run.getOutputStream()
        .flush();

run.getOutputStream()
        .close();
        boolean finished =
        run.waitFor(
                2,
                java.util.concurrent.TimeUnit.SECONDS
        );

if(!finished){

    run.destroyForcibly();

    return "⏱️ Time Limit Exceeded";

}

BufferedReader reader =
        new BufferedReader(
                new InputStreamReader(
                        run.getInputStream()
                )
        );

BufferedReader errorReader =
        new BufferedReader(
                new InputStreamReader(
                        run.getErrorStream()
                )
        );

StringBuilder output =
        new StringBuilder();
StringBuilder errors =
        new StringBuilder();

String line;

while((line = reader.readLine()) != null){

    output.append(line)
          .append("\n");

}

while((line = errorReader.readLine()) != null){

    errors.append(line)
          .append("\n");

}

if(errors.length() > 0){

    return "💥 Runtime Error\n\n"
            + errors.toString();

}

String result =
        output.toString().trim();

if(code.contains("class Solution")){

    Object[][] tests =
            judgeService
                    .getBinarySearchTests();

    for(Object[] test : tests){

        int[] nums =
                (int[]) test[0];

        int target =
                (Integer) test[1];

        String expected =
                (String) test[2];

        String generatedCode =
                code +
                "\n" +
                mainGeneratorService
                        .generateBinarySearchMain(
                                nums,
                                target
                        );

        String actual =
                executeCode(
                        generatedCode
                );

        if(!actual.equals(expected)){
                saveSubmission(
        "Binary Search",
        "Wrong Answer"
);

            return "❌ Wrong Answer";

        }

    }
    saveSubmission(
    "Binary Search",
    "Accepted"
);

progressService.markSolved(
        "stuti",
        questionTitle
);

revisionService.scheduleRevision(
        "stuti",
        questionTitle
);

User user =
        userRepository
        .findByUsername(
                "stuti"
        )
        .orElseThrow();

user.setXp(
        user.getXp() + 25
);

user.setLevel(
        xpService.calculateLevel(
                user.getXp()
        )
);

userRepository.save(user);

return "✅ Accepted\n\n"
        +
        aiMentorService.review(
                code
        );

}

return result;
    }
    catch(Exception e){

        return e.getMessage();

    }
    

}
private String executeCode(
        String finalCode
) throws Exception {

    java.nio.file.Files.writeString(
            java.nio.file.Path.of("Main.java"),
            finalCode
    );

    Process compile =
            new ProcessBuilder(
                    "javac",
                    "Main.java"
            ).start();

    compile.waitFor();

    if(compile.exitValue() != 0){

        return "COMPILE_ERROR";

    }

    Process run =
            new ProcessBuilder(
                    "java",
                    "Main"
            ).start();

    boolean finished =
            run.waitFor(
                    2,
                    java.util.concurrent.TimeUnit.SECONDS
            );

    if(!finished){

        run.destroyForcibly();

        return "TIME_LIMIT";

    }

    BufferedReader reader =
            new BufferedReader(
                    new InputStreamReader(
                            run.getInputStream()
                    )
            );

    StringBuilder output =
            new StringBuilder();

    String line;

    while((line = reader.readLine()) != null){

        output.append(line);

    }

    return output.toString().trim();
}
@PostMapping("/review")
public String review(
        @RequestBody String code
){

    return aiReviewService
            .review(code);
}
private void saveSubmission(
        String questionName,
        String verdict
){

    Submission submission =
            new Submission();

    submission.setUsername("stuti");

    submission.setQuestionName(
            questionName
    );

    submission.setVerdict(
            verdict
    );

    submission.setSubmittedAt(
            java.time.LocalDateTime.now()
    );

    submissionRepository.save(
            submission
    );
}
}
