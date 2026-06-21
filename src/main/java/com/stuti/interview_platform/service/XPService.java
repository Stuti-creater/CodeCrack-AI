package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

@Service
public class XPService {

    public int calculateLevel(
            int xp
    ){

        return (xp / 100) + 1;

    }

}