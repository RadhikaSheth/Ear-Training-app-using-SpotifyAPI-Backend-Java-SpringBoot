package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz,String> {
    List<Quiz> findByUserId(String userId);

}
