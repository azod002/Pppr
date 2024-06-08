package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pppr.R;
import com.example.pppr.databinding.ActivityMakeQuestionsBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MakeQuestions extends AppCompatActivity {
    private ActivityMakeQuestionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakeQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSave.setOnClickListener(v -> {
            String name = binding.editText.getText().toString();
            String uidsString = binding.uidsInput.getText().toString();
            List<String> uids = new ArrayList<>();
            for (String uid : uidsString.split(",")) {
                uids.add(uid.trim());
                uids.add(FirebaseAuth.getInstance().getUid().toString());
            }
            String uidlist = String.join(",", uids);
            if (name.isEmpty()) {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
            } else {
                Question question = new Question(FirebaseAuth.getInstance().getCurrentUser().getUid(), name, uidlist);
                MakeQuestionsViewModel.getInstance(this, name).saveQuestion(question);
            }

        });
        binding.backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}


