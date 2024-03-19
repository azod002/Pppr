package com.example.pppr.database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity (tableName = "Group")
public class Group {
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "photoURL")
    private String photoURL;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "creatorId")
    private int creatorId;

}
