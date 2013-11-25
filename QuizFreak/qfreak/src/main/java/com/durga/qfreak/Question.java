package com.durga.qfreak;

/**
 * Created by Durga on 24/11/13.
 */
public class Question {

    public Question(String question, String answer, String hint, QuestionType type, String fact,int timeLimit, String[] options) {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.type = type;
        this.fact = fact;
        this.options = options;
        this.timeLimit = timeLimit;
    }

    public enum QuestionType{
        ANAGRAM, MCQ, HANGMAN, TRF;
    }

    public String question;
    public String answer;
    public String hint;
    public QuestionType type;
    public String fact;
    public String[] options;
    public int timeLimit;


    public boolean answered = false;
    public int timeLeft;
    public boolean answeredCorrect;
    public int score;


}


