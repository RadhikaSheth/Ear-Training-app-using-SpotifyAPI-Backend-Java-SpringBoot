package com.example.demo;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class Controller {
    @Autowired
    private QuizService quizService;

    @GetMapping(path = "/user", produces = "application/json")
    @CrossOrigin(origins = "*")
    public List<Quiz> getUserProfile(@RequestParam String userId, @RequestParam String accessToken) throws ParseException, SpotifyWebApiException, IOException {
        return quizService.getProfile(userId,accessToken);
    }

    @PostMapping(path = "/entry", consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*")
    public Quiz add(@RequestBody Quiz quiz,@RequestParam String userId, @RequestParam String accessToken) throws ParseException, SpotifyWebApiException, IOException {
        quizService.appendEntry(quiz,userId,accessToken);
        return quiz;
    }
}
