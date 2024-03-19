package com.example.pppr.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "questionAnswer",
        foreignKeys = {
            @ForeignKey(entity = Users.class,
            parentColumns = "id",
            childColumns = "userId",
            onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = question.class,
            parentColumns = "name",
            childColumns = "Groupname",
            onDelete = ForeignKey.CASCADE)
        })
public class Groupcomp {
    @ColumnInfo(name = "userId")
    private String userId;
    @ColumnInfo(name = "Groupname")
    private String Groupname;
}
