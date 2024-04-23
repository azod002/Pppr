package com.example.pppr.Firebase;

public class questions {
    private String id;
    private String question;

    public questions(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public questions() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
