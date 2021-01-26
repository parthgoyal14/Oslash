package com.example.oslash.demo.controller;

import com.example.oslash.demo.model.Tweet;
import com.example.oslash.demo.model.User;
import com.example.oslash.demo.service.TweetService;
import com.example.oslash.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/oslash")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @PostMapping("/tweet")
    public ResponseEntity<Tweet> createTweet(@RequestBody Tweet tweet){
        System.out.println(tweet.getText());
        Tweet newTweet = tweetService.createTweet(tweet);
        return ResponseEntity.ok(newTweet);
    }

    @GetMapping("/tweets")
    public List<Tweet> getAllTweets(){
        return tweetService.getAllTweets();
    }

    @GetMapping("/tweets/{userId}")
    public ResponseEntity<List<Tweet>> getTweetsByUserId(@PathVariable(value = "userId") Long userId){
        List<Tweet> tweetsByUser = tweetService.getAllTweetsByUserId(userId);
        return ResponseEntity.ok().body(tweetsByUser);
    }

    @DeleteMapping("/tweets/{tweetId}")
    public Map<String, Boolean> deleteTweet(@PathVariable(value = "tweetId") Long tweetId) {
        return tweetService.deleteTweet(tweetId);
    }
}
