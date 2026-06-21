package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.repository.PostRepository;
import com.stuti.interview_platform.service.SocialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SocialController {

    @Autowired
    private SocialService service;

    @Autowired
private PostRepository postRepository;

    @PostMapping("/follow")
    @ResponseBody
    public String follow(

            @RequestParam String follower,

            @RequestParam String following

    ){

        service.followUser(
                follower,
                following
        );

        return "Followed";

    }
    @GetMapping("/u/{username}")
public String publicProfile(

@PathVariable String username,

Model model

){

model.addAttribute(
"username",
username
);

model.addAttribute(
        "followers",
        service.getFollowers(username)
);

model.addAttribute(
        "following",
        service.getFollowing(username)
);

model.addAttribute(
"xp",
2450
);

model.addAttribute(
"solved",
162
);

return "public-profile";

}
@GetMapping("/feed")
public String feed(Model model){

    model.addAttribute(

            "posts",

            service.getFeed()

    );

    return "feed";

}
@PostMapping("/like")
@ResponseBody
public String like(

        @RequestParam Long postId

){

    service.likePost(

            postId,

            "stuti"

    );

    return "Liked";

}

}