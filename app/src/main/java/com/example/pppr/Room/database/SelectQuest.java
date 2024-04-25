package com.example.pppr.Room.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pppr.R;
import com.example.pppr.databinding.ActivitySelectQuestBinding;

public class SelectQuest extends AppCompatActivity {
    private ActivitySelectQuestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectQuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






    }
}