package com.example.pppr.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pppr.R;
import com.example.pppr.databinding.ActivityMakeQuestionsBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MakeQuestions extends AppCompatActivity {
    private ActivityMakeQuestionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakeQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSave.setOnClickListener(v -> {
            String name = binding.editText.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
            } else {
                Question question = new Question(FirebaseAuth.getInstance().getCurrentUser().getUid(), name);
                MakeQuestionsViewModel.getInstance(this, name).saveQuestion(question);
            }

        });
        binding.backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}


