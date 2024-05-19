package com.example.pppr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pppr.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.uid.setText(FirebaseAuth.getInstance().getUid().toString());
        binding.copy.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", FirebaseAuth.getInstance().getUid().toString());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Текст скопирован", Toast.LENGTH_SHORT).show();
        });
        binding.backButton.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}