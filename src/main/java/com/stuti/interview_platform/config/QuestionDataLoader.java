package com.stuti.interview_platform.config;

import com.stuti.interview_platform.entity.QuestionEntity;
import com.stuti.interview_platform.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.stuti.interview_platform.service.QuestionService;
import com.stuti.interview_platform.model.Question;

@Component
public class QuestionDataLoader implements CommandLineRunner {

    private final QuestionRepository repository;
private final QuestionService questionService;

public QuestionDataLoader(
        QuestionRepository repository,
        QuestionService questionService
) {

    this.repository = repository;
    this.questionService = questionService;

}

    @Override
public void run(String... args) {

    if(repository.count() > 0){

        return;

    }

    questionService
            .getAllQuestions()
            .values()
            .forEach(this::saveQuestion);

}
    private void saveQuestion(Question question){

    QuestionEntity entity =
            new QuestionEntity();

    entity.setTitle(
            question.getTitle()
    );

    entity.setDifficulty(
            question.getDifficulty()
    );

    entity.setCompany(
            question.getCompany()
    );

    entity.setTopic(
            question.getTopic()
    );

    entity.setDescription(
            question.getDescription()
    );

    entity.setExample(
            question.getExample()
    );

    entity.setStarterCode(
            question.getStarterCode()
    );

    entity.setHint1(
            question.getHint()
    );

    repository.save(entity);

}
}