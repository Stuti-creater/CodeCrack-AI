package com.stuti.interview_platform.repository;

import com.stuti.interview_platform.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import java.util.Optional;

public interface UserProgressRepository
        extends JpaRepository<UserProgress, Long> {

    long countByUsernameAndSolvedTrue(String username);

    Optional<UserProgress>
    findByUsernameAndQuestionName(
            String username,
            String questionName
    );
    @Query("""
SELECT u.username,
COUNT(u)
FROM UserProgress u
WHERE u.solved = true
AND u.username IS NOT NULL
AND u.username <> ''
GROUP BY u.username
ORDER BY COUNT(u) DESC
""")
List<Object[]> getLeaderboard();
List<UserProgress>
findByUsernameAndSolvedTrue(
        String username
);
void deleteByUsername(
        String username
);
} 