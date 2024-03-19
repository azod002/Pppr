package com.example.pppr.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "main")
public class MainEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "varnum")
    private int varnum;

    @ColumnInfo(name = "idofView")
    private int idofView;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "question")
    private String question;

    public void setId(int id) {
        this.id = id;
    }

    public void setVarNum(int varNum) {
        varnum = varNum;
    }

    public void setIdofView(int idofView) {
        this.idofView = idofView;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public int getVarNum() {
        return varnum;
    }

    public int getIdofView() {
        return idofView;
    }

    public int getVarnum() {return varnum;}

    public MainEntity() {

    }

    public MainEntity(int varnum, int idofView, String content, String question) {
        this.varnum = varnum;
        this.idofView = idofView;
        this.content = content;
        this.question = question;
    }

    public void setVarnum(int varnum) {
        this.varnum = varnum;
    }

    public String getContent() {
        return content;
    }

    public String getQuestion() {
        return question;
    }
}

