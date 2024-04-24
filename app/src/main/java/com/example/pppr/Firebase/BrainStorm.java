package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pppr.databinding.ActivityBrainstormBinding;
import com.google.firebase.auth.FirebaseAuth;


public class BrainStorm extends AppCompatActivity {

    private ContentAdapter adapter;

    private ActivityBrainstormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBrainstormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String questionId = getIntent().getStringExtra("questionId");
        System.out.println(questionId);
        initviews(questionId);
        initRecyclerView(questionId);
    }

    public void initviews(String questionId) {
        binding.buttonSave.setOnClickListener(v -> {
            String contentstr = binding.editTextContent.getText().toString();
            if (contentstr.isEmpty()) {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
                return;
            }
            Content content = new Content(FirebaseAuth.getInstance().getCurrentUser().getUid(), contentstr);
            BrainStormViewModel.getInstance(this, questionId).saveContent(content);
        });

        binding.backButton.setOnClickListener(v -> {
            finish();
        });


    }

    private void initRecyclerView(String questionId) {
        adapter = new ContentAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BrainStormViewModel.getInstance(this, questionId).getUsersLiveData().observe(this, new Observer<ContentData>() {
            @Override
            public void onChanged(ContentData contentData) {
                adapter.update(contentData.getContents());
                String name = contentData.getName();
                binding.savedtext.setText(name);
            }
        });
    }


}