package com.company.Summative1YuanyuanZhao.models;

public class Answer {
    int id;
    String question;
    String answer;

    public Answer() {
    }

    public Answer(String question, String answer, int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
