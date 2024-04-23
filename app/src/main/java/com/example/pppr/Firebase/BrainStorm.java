package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pppr.Firebase.Content;
import com.example.pppr.R;
import com.example.pppr.RecyclerView.NewAdapter;
import com.example.pppr.database.AppDatabase;
import com.example.pppr.database.DatabaseManager;
import com.example.pppr.databinding.ActivityBrainstormBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


public class BrainStorm extends AppCompatActivity {

    private ContentAdapter adapter;

    private ActivityBrainstormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBrainstormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra("name");
        System.out.println(name);
        initviews(name);
        initRecyclerView(name);
    }

    public void initviews(String path) {
        binding.buttonSave.setOnClickListener(v -> {
            String contentstr = binding.editTextContent.getText().toString();
            if (contentstr.isEmpty()) {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
                return;
            }
            Content content = new Content(FirebaseAuth.getInstance().getCurrentUser().getUid(), contentstr);
            BrainStormViewModel.getInstance(this, path).saveContent(content);
        });

        binding.backButton.setOnClickListener(v -> {
            finish();
        });


    }

    private void initRecyclerView(String path) {
        adapter = new ContentAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BrainStormViewModel.getInstance(this, path).getUsersLiveData().observe(this, new Observer<ContentData>() {
            @Override
            public void onChanged(ContentData contentData) {
                adapter.update(contentData.getContents());
                String name = contentData.getName();
                binding.savedtext.setText(name);
            }
        });
    }


}