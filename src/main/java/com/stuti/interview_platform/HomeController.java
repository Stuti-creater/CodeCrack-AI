package com.stuti.interview_platform;

import com.stuti.interview_platform.repository.SubmissionRepository;
import com.stuti.interview_platform.repository.UserProgressRepository;
import java.security.Principal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import com.stuti.interview_platform.entity.ContestResult;
import com.stuti.interview_platform.model.Question;
import com.stuti.interview_platform.service.AchievementService;
import com.stuti.interview_platform.service.QuestionService;
import com.stuti.interview_platform.repository.InterviewHistoryRepository;
import com.stuti.interview_platform.repository.QuestionRepository;
import com.stuti.interview_platform.service.WeaknessService;
import com.stuti.interview_platform.service.CompanyReadinessService;
import com.stuti.interview_platform.service.ContestResultService;
import com.stuti.interview_platform.service.GroqService;
import com.stuti.interview_platform.service.StudyPlannerService;
import com.stuti.interview_platform.service.InterviewQuestionService;
import com.stuti.interview_platform.service.PatternWeaknessService;
import com.stuti.interview_platform.service.ProgressResetService;

import java.time.LocalDate;
import com.stuti.interview_platform.repository.RevisionScheduleRepository;
import com.stuti.interview_platform.service.RevisionService;
import com.stuti.interview_platform.repository.UserRepository;
import com.stuti.interview_platform.service.XPService;
import com.stuti.interview_platform.entity.UserProgress;
import com.stuti.interview_platform.repository.InterviewHistoryRepository;
import com.stuti.interview_platform.service.SocialService;


@Controller
public class HomeController {

    @Autowired
    private UserProgressRepository repository;

    @Autowired
private QuestionService questionService;

@Autowired
private AchievementService achievementService;

@Autowired
private SubmissionRepository submissionRepository;

@Autowired
private QuestionRepository questionRepository;

@Autowired
private WeaknessService weaknessService;

@Autowired
private CompanyReadinessService companyReadinessService;

@Autowired
private StudyPlannerService studyPlannerService;

@Autowired
private InterviewQuestionService
        interviewQuestionService;

        @Autowired
private PatternWeaknessService
        patternWeaknessService;

        @Autowired
private RevisionScheduleRepository
        revisionScheduleRepository;

@Autowired
private ContestResultService
        contestResultService;

        @Autowired
private ProgressResetService
        progressResetService;
        @Autowired
private GroqService groqService;
@Autowired
private InterviewHistoryRepository
        interviewHistoryRepository;
        @Autowired
private SocialService socialService;
        

@GetMapping("/history")
public String history(
        Principal principal,
        Model model
){

    model.addAttribute(
            "history",
            submissionRepository
                    .findByUsernameOrderBySubmittedAtDesc(
        principal.getName()
)
                    );

    return "history";
}


   @GetMapping("/home")
public String homePage(
        Principal principal,
        Model model
) {

    String username =
            principal.getName();

    long solvedCount =
            repository.countByUsernameAndSolvedTrue(
                    username
            );
            model.addAttribute(
        "username",
        username
);
    model.addAttribute(
            "solvedCount",
            solvedCount
    );

    model.addAttribute(
            "achievement",
            achievementService
                    .getAchievement(solvedCount)
    );

    model.addAttribute(
            "questions",
            questionRepository.findAll()
    );
    model.addAttribute(
        "feed",
        socialService.getFeed()
);

    return "home";
}

    @GetMapping("/practice")
    public String practice() {
        return "practice";
    }

    @GetMapping("/mock")
    public String mock() {
        return "mock";
    }

    @GetMapping("/progress")
public String progress(
        Principal principal,
        Model model
) {

    long solvedCount =
            repository.countByUsernameAndSolvedTrue(
                    principal.getName()
            );

    model.addAttribute(
            "solvedCount",
            solvedCount
    );

    return "progress";
}
@GetMapping("/company/{company}")
public String companySheet(
        @PathVariable String company,
        Model model
){

    Map<String, Question> companyQuestions =
            questionService
                    .getAllQuestions()
                    .entrySet()
                    .stream()
                    .filter(q ->
                            q.getValue()
                             .getCompany()
                             .equalsIgnoreCase(company)
                    )
                    .collect(
                            Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue
                            )
                    );

    model.addAttribute(
            "questions",
            companyQuestions
    );

    model.addAttribute(
            "company",
            company
    );

    return "company-sheet";
}
@GetMapping("/leaderboard")
public String leaderboard(Model model){

    model.addAttribute(
            "leaders",
            repository.getLeaderboard()
    );

    return "leaderboard";
}

@GetMapping("/topic/{topic}")
public String topicSheet(
        @PathVariable String topic,
        Model model
){

    System.out.println("Topic = " + topic);

    System.out.println(
            questionService
                    .getAllQuestions()
                    .values()
                    .stream()
                    .filter(q ->
                            q.getTopic()
                                    .equalsIgnoreCase(topic)
                    )
                    .count()
    );

    Map<String, Question> topicQuestions =
            questionService
                    .getAllQuestions()
                    .entrySet()
                    .stream()
                    .filter(q ->
                            q.getValue()
                                    .getTopic()
                                    .equalsIgnoreCase(topic)
                    )
                    .collect(
                            Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue
                            )
                    );

    model.addAttribute(
            "questions",
            topicQuestions
    );

    model.addAttribute(
            "company",
            topic
    );

    return "company-sheet";
}
@GetMapping("/topics")
public String topics() {

    return "topics";

}
@GetMapping("/profile")
public String profile(
        Principal principal,
        Model model
){

    long solved =
            repository
            .countByUsernameAndSolvedTrue(
                    principal.getName()
            );

    int xp =
            (int) solved * 50;

    int level =
            xp / 100 + 1;

    int streak =
            repository
            .findByUsernameAndSolvedTrue(
                   principal.getName()
            )
            .stream()
            .mapToInt(
                    UserProgress::getStreak
            )
            .max()
            .orElse(0);

    model.addAttribute(
            "solved",
            solved
    );

    model.addAttribute(
            "xp",
            xp
    );

    model.addAttribute(
            "level",
            level
    );

    model.addAttribute(
            "streak",
            streak
    );
    model.addAttribute(
        "badges",
        achievementService
                .getBadges(
                        solved
                )
);

    return "profile";
}
@GetMapping("/contest")
public String contest(){

    return "contest";
}
@GetMapping("/mock-interview")
public String mockInterview(
        @RequestParam(
                defaultValue = "google"
        )
        String company,

        Model model
){

    model.addAttribute(
            "questions",
            interviewQuestionService
                    .getQuestions(
                            company
                    )
    );

    model.addAttribute(
            "company",
            company
    );

    return "mock-interview";
}
@GetMapping("/questions")
public String questions(Model model){

    model.addAttribute(
            "questions",
            questionRepository.findAll()
    );

    return "questions";
}
@GetMapping("/question/{id}")
public String question(
        @PathVariable Long id
){

    String questionName =

            questionRepository
                    .findById(id)
                    .orElseThrow()
                    .getTitle();

    return

            "redirect:/question?name="

            +

            questionName;
}
@GetMapping("/roadmap")
public String roadmap(
        Model model
){

    String weakestTopic =
            weaknessService
                    .getWeakestTopic();

    model.addAttribute(
            "weakestTopic",
            weakestTopic
    );

    model.addAttribute(
            "todayPlan",
            studyPlannerService
                    .getTodayPlan(
                            weakestTopic
                    )
    );

    model.addAttribute(
            "googleScore",
            companyReadinessService
                    .getGoogleScore()
    );

    model.addAttribute(
            "amazonScore",
            companyReadinessService
                    .getAmazonScore()
    );

    model.addAttribute(
            "metaScore",
            companyReadinessService
                    .getMetaScore()
    );

    model.addAttribute(
        "weakPatterns",
        patternWeaknessService
                .getWeakPatterns()
);

    return "roadmap";
}
@GetMapping("/revision")
public String revision(
        Principal principal,
        Model model
){

    model.addAttribute(

            "revisions",

            repository.findByUsernameAndSolvedTrue(

                    principal.getName()

            )

    );

    return "revision";
}
@GetMapping("/contest/start")
public String contestStart(
        Model model
){

    model.addAttribute(
            "contestName",
            "Weekly Contest #28"
    );

    model.addAttribute(
            "questions",
            questionRepository
                    .findRandomQuestions()
    );

    return "contest-start";

}
@GetMapping("/contest/results")
public String contestResults(
        Principal principal,
        Model model
){

    ContestResult result =

            contestResultService
                    .saveResult(

principal.getName(),

                            3

                    );

    model.addAttribute(

            "score",

            result.getScore()

    );

    model.addAttribute(

            "total",

            5

    );

    model.addAttribute(

            "rank",

            result.getRank()

    );

    model.addAttribute(

            "xpEarned",

            result.getXpEarned()

    );

    return "contest-results";

}



@GetMapping("/ai-practice")
public String aiPractice(Model model) {

    String weakestTopic =
            weaknessService.getWeakestTopic();

    model.addAttribute(
            "weakestTopic",
            weakestTopic
    );

    Map<String, Question> recommendedQuestions =
            questionService
                    .getAllQuestions()
                    .entrySet()
                    .stream()
                    .filter(q ->
                            q.getValue()
                             .getTopic()
                             .equalsIgnoreCase(weakestTopic)
                    )
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    ));

    model.addAttribute(
            "questions",
            recommendedQuestions
    );

    return "ai-practice";
}
@GetMapping("/settings")
public String settings() {

    return "settings";

}
@PostMapping("/reset-progress")
public String resetProgress(
        Principal principal
){

    progressResetService
            .resetProgress(
                    principal.getName()
            );

    return "redirect:/profile";
}
@GetMapping("/confirm-reset")
public String confirmReset() {

    return "confirm-reset";

}
@PostMapping("/generate-question")
@ResponseBody
public String generateQuestion(

        @RequestParam String company,

        @RequestParam int questionNumber

){

    return groqService.generateInterviewQuestion(

            company,

            questionNumber

    );
}
@GetMapping("/test-question")
@ResponseBody
public String testQuestion(){

    return groqService.generateInterviewQuestion(

            "Google",

            1

    );
}
@GetMapping("/interview-history")
public String interviewHistory(
        Principal principal,
        Model model
){

    model.addAttribute(
            "history",
            interviewHistoryRepository
                    .findByUsernameOrderByIdDesc(
                            principal.getName()
                    )
    );

    return "interview-history";
}
}
