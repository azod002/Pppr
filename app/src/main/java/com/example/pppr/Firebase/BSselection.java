package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.pppr.databinding.ActivityBsselectionBinding;

import java.util.List;

public class BSselection extends AppCompatActivity {

    private ActivityBsselectionBinding binding;
    private ContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBsselectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    private void initRecyclerView() {
        adapter = new ContentAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BrainStormViewModel.getInstance(this).getUsersLiveData().observe(this, new Observer<List<Content>>() {
            @Override
            public void onChanged(List<Content> users) {
                adapter.update(users);
            }
        });
    }}