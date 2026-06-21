package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

@Service
public class JudgeService {

    public Object[][] getBinarySearchTests(){

        return new Object[][]{

                {
                        new int[]{
                                -1,0,3,5,9,12
                        },
                        9,
                        "4"
                },

                {
                        new int[]{
                                -1,0,3,5,9,12
                        },
                        2,
                        "-1"
                },

                {
                        new int[]{
                                -1,0,3,5,9,12
                        },
                        -1,
                        "0"
                }

        };

    }

}