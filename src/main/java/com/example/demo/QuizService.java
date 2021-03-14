package com.example.demo;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.User;
@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;
    public boolean checkUser(String userId, String accessToken) throws ParseException, SpotifyWebApiException, IOException {
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        User user = getCurrentUsersProfileRequest.execute();
        return user.getId().equals(userId);
    }
    public List<Quiz> getProfile(String userId, String accessToken) throws ParseException, SpotifyWebApiException, IOException {
        List<Quiz> userList = new ArrayList<>();
        if(checkUser(userId,accessToken)) {
            userList.addAll(quizRepo.findByUserId(userId));
        }
        return userList;
    }

    public void appendEntry(Quiz quiz,String userId,String accessToken) throws ParseException, SpotifyWebApiException, IOException {
        if(checkUser(userId,accessToken)){
            quizRepo.save(quiz);
        }

    }
}

