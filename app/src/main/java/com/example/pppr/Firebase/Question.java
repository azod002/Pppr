package com.example.pppr.Firebase;

public class Question {
    private String id;
    private String name;

    private String uidlist;

    public Question() {}

    public Question(String id, String name, String uidlist) {
        this.id = id;
        this.name = name;
        this.uidlist = uidlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUidlist() {
        return uidlist;
    }

    public void setUidlist(String uidlist) {
        this.uidlist = uidlist;
    }
}
