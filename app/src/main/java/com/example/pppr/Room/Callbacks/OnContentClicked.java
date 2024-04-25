package com.example.pppr.Room.Callbacks;

import com.example.pppr.Room.database.Entity.ContentDB;

public interface OnContentClicked {
    public void onRemoveClicked(ContentDB contentDB);

    public void onJustClicked(ContentDB contentDB);
}
