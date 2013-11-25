package com.durga.qfreak;

import android.app.Application;

import screens.AnagramActivity;
import screens.HangmanActivity;
import screens.MCQActivity;
import screens.TRFActivity;

/**
 * Created by Durga on 24/11/13.
 */
public class GameLogicEngine extends Application {

    public GameLogicEngine() {
        this.loadLevel();
    }

    public Question[] level;
    public int questionsOffset;
    public Question currQues;
    public char[] workingAnswer;
    public int workingOffset;
    public int timeLeft;
    public int scoreAward;
    public int timeAward;
    public int totalScore;


    public void loadLevel(){
        this.questionsOffset = 0;
        this.level = new Question[3];
        this.level[0] = new Question(
                "What is the Capital of India?",
                "New Delhi",
                "Its also a union territory",
                Question.QuestionType.ANAGRAM,
                "New Delhi is the capital of India.",
                20,
                new String[]{"NEWDELHI"}
        );
        this.level[1] = new Question(
                "What is the Capital of India?",
                "New Delhi",
                "Its also a union territory",
                Question.QuestionType.MCQ,
                "New Delhi is the capital of India.",
                20,
                new String[]{"New Delhi", "Bombay", "Chennai", "Goa"}
        );

        this.level[2] = new Question(
                "Bombay is the capital of India",
                "False",
                "Its also a union territory",
                Question.QuestionType.TRF,
                "New Delhi is the capital of India.",
                20,
                null
        );
        this.currQues = this.level[this.questionsOffset];
    }


    public void processAnswer() {
        if(this.currQues.answered == false){
            return;
        }
        if((new String(this.workingAnswer).equalsIgnoreCase(this.currQues.answer))) {
            this.scoreAward = 100;
            this.timeAward  = timeLeft*2;
            this.currQues.answeredCorrect = true;
        }
        else {
            this.scoreAward = 0;
            this.timeAward  = 0;
            this.currQues.answeredCorrect = false;
        }
        this.currQues.score = this.scoreAward + this.timeAward;
        this.currQues.timeLeft = this.timeLeft;
        this.totalScore += this.currQues.score;
    }

    public String getDisplayWorkingAnswer() {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < this.workingAnswer.length; i++){
            sb.append(this.workingAnswer[i]);
            sb.append(' ');
        }
        return sb.toString();
    }

    public Class getNextQuestion() {
        this.processAnswer();
        this.questionsOffset++;
        this.currQues = this.level[this.questionsOffset];
        switch (this.currQues.type){
            case MCQ:
                return MCQActivity.class;
            case ANAGRAM:
                return AnagramActivity.class;
            case TRF:
                return TRFActivity.class;
            case HANGMAN:
                return HangmanActivity.class;
        }
        return null;
    }
}
