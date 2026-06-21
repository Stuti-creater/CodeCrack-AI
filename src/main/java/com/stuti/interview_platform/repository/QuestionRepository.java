package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import java.util.List;

public interface QuestionRepository
        extends JpaRepository<QuestionEntity, Long> {

    List<QuestionEntity>
    findByCompany(String company);

    List<QuestionEntity>
    findByTopic(String topic);

    List<QuestionEntity> findByDifficulty(String difficulty);
    long countByCompany(String company);
    Optional<QuestionEntity>
findByTitle(String title);
    @Query(
        value =
                "SELECT * FROM question_entity ORDER BY RAND() LIMIT 5",
        nativeQuery = true
)
List<QuestionEntity> findRandomQuestions();

}