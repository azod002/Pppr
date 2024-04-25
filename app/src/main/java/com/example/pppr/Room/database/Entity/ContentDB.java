package com.example.pppr.Room.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ContentDB")
public class ContentDB {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "Metnum")
    private int Metnum;

    @ColumnInfo(name = "idofview")
    private int idofview;

    @ColumnInfo(name = "content")
    private String content;

    public ContentDB(String question, int metnum, int idofview, String content) {
        this.question = question;
        Metnum = metnum;
        this.idofview = idofview;
        this.content = content;
    }

    public ContentDB() {}

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

    public int getMetnum() {
        return Metnum;
    }

    public void setMetnum(int metnum) {
        Metnum = metnum;
    }

    public int getIdofview() {
        return idofview;
    }

    public void setIdofview(int idofview) {
        this.idofview = idofview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
