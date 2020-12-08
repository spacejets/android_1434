package com.example.myapplication;

public class Question {
    private int questionReId;
    private boolean answerTrue;


    public Question(int questionReId, boolean answerTrue) {
        this.questionReId = questionReId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionReId() {
        return questionReId;
    }

    public void setQuestionReId(int questionReId) {
        this.questionReId = questionReId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
