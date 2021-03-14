package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name ="quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "quiz_date")
    private String quizDate;
    @Column(name = "quiz_type")
    private String quizType;
    @Column(name = "quiz_id")
    private String quizId;
    @Column(name = "correct")
    private int correctVal;
    @Column(name = "incorrect")
    private int incorrectVal;
    @Column(name = "skipped")
    private int skippedVal;


    public Quiz(Integer id, String userId, String quizDate, String quizType, String quizId, int correctVal, int incorrectVal, int skippedVal) {
        this.id = id;
        this.userId = userId;
        this.quizDate = quizDate;
        this.quizType = quizType;
        this.quizId = quizId;
        this.correctVal = correctVal;
        this.incorrectVal = incorrectVal;
        this.skippedVal = skippedVal;
    }

    public Quiz() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setQuizDate(String quizDate) { this.quizDate = quizDate; }

    public void setQuizType(String quizType) {
        this.quizType = quizType;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setCorrectVal(int correctVal) {
        this.correctVal = correctVal;
    }

    public void setIncorrectVal(int incorrectVal) {
        this.incorrectVal = incorrectVal;
    }

    public void setSkippedVal(int skippedVal) {
        this.skippedVal = skippedVal;
    }

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getQuizDate() { return quizDate; }

    public String getQuizType() {
        return quizType;
    }

    public String getQuizId() {
        return quizId;
    }

    public int getCorrectVal() {
        return correctVal;
    }

    public int getIncorrectVal() {
        return incorrectVal;
    }

    public int getSkippedVal() {
        return skippedVal;
    }
}
