package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pppr.MainActivity;
import com.example.pppr.databinding.ActivityBsselectionBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BSselection extends AppCompatActivity {

    private ActivityBsselectionBinding binding;
    private BSselViewModel viewModel;
    private NameAdapter adapter;
    private boolean areFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBsselectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(com.example.pppr.Firebase.BSselViewModel.class);
        viewModel.getQuestions().observe(this, questions -> {
            adapter = new NameAdapter(this, questions);
            binding.recyclerView.setAdapter(adapter);
        });
        binding.backButton.setOnClickListener(v -> {
            finish();
        });
        binding.makeQ.setOnClickListener(v -> {
            Intent a;
            a = new Intent(BSselection.this, MakeQuestions.class);
            startActivity(a);
        });
        binding.delete.setOnClickListener(v -> {
            viewModel.deleteUserQuestion();
        });
        binding.mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areFabsVisible = !areFabsVisible;
                binding.childFab1.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
                binding.childFab2.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
                binding.childFab3.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);                }
        });
        binding.childFab1.setOnClickListener(v -> {
            viewModel.deleteUserQuestion();
        });
    }
}