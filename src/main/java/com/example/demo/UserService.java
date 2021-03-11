package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public List<User> getProfile(String userId, String accessToken){
        List<User> userList = new ArrayList<>();
        userRepo.findByUserId( userId).forEach(userList::add);
        return userList;
    }

    public void appendEntry(User user,String accessToken){
        userRepo.save(user);
    }
}

