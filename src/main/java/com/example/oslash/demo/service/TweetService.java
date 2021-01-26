package com.example.oslash.demo.service;

import com.example.oslash.demo.model.Tweet;
import com.example.oslash.demo.model.User;
import com.example.oslash.demo.repository.TweetRepository;
import com.example.oslash.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TweetService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet createTweet(Tweet tweet){
        return this.tweetRepository.save(tweet);
    }

    public List<Tweet> getAllTweets(){
        return this.tweetRepository.findAll();
    }

    public List<Tweet> getAllTweetsByUserId(Long userId){
        Optional<User> user = userService.getUserByUserId(userId);
        return this.tweetRepository.findByUserId(userId);
    }

    public Map<String, Boolean> deleteTweet(Long tweetId){
        Map<String, Boolean> response = new HashMap<>();
        try{
            this.tweetRepository.deleteById(tweetId);
        }
        catch (Exception e){
            response.put("Not Deleted", Boolean.FALSE);
            return response;
        }
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
