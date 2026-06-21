package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.Follow;
import com.stuti.interview_platform.entity.Post;
import com.stuti.interview_platform.repository.FollowRepository;
import com.stuti.interview_platform.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.stuti.interview_platform.entity.Like;
import com.stuti.interview_platform.repository.LikeRepository;

@Service
public class SocialService {

    @Autowired
    private FollowRepository repository;

    @Autowired
private PostRepository postRepository;

@Autowired
private LikeRepository likeRepository;

    public void followUser(
            String follower,
            String following
    ){

        if(repository.existsByFollowerAndFollowing(
                follower,
                following
        )){

            return;

        }

        Follow follow =
                new Follow();

        follow.setFollower(follower);

        follow.setFollowing(following);

        repository.save(follow);

    }
    public long getFollowers(String username){

    return repository.countByFollowing(username);

}

public long getFollowing(String username){

    return repository.countByFollower(username);

}
public void createPost(

        String username,

        String content,

        String type

){

    Post post = new Post();

    post.setUsername(username);

    post.setContent(content);

    post.setType(type);

    postRepository.save(post);

}
public List<Post> getFeed(){

    return postRepository.findAllByOrderByCreatedAtDesc();

}
public void likePost(

        Long postId,

        String username

){

    if(

            likeRepository.existsByPostIdAndUsername(

                    postId,

                    username

            )

    ){

        return;

    }

    Like like = new Like();

    like.setPostId(postId);

    like.setUsername(username);

    likeRepository.save(like);

}
public long getLikes(

        Long postId

){

    return likeRepository.countByPostId(postId);

}

}