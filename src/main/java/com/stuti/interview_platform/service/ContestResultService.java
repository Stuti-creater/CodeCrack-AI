package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.ContestResult;
import com.stuti.interview_platform.repository.ContestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContestResultService {

    @Autowired
    private ContestResultRepository repository;

    public ContestResult saveResult(
            String username,
            int score
    ){

        ContestResult result =
                new ContestResult();

        result.setUsername(
                username
        );

        result.setScore(
                score
        );

        result.setXpEarned(
                score * 50
        );

        result.setRank(
                calculateRank(score)
        );

        return repository.save(
                result
        );

    }

    private int calculateRank(
            int score
    ){

        if(score == 5){

            return 1;

        }

        else if(score == 4){

            return 5;

        }

        else if(score == 3){

            return 15;

        }

        else{

            return 50;

        }

    }

}
