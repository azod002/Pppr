package com.example.pppr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pppr.Auth.Register;
import com.example.pppr.Firebase.BSselection;
import com.example.pppr.Methodics.AnsFromTime;
import com.example.pppr.Room.RoomDebug;
import com.example.pppr.Room.database.SelectQuest;
import com.example.pppr.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText inputField;
    private String savedText;
    private ActivityMainBinding binding;

    private boolean areFabsVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        inputField = findViewById(R.id.inputField);


        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            Intent a;
            a = new Intent(MainActivity.this, Register.class);
            startActivity(a);
            finish();
        }
        else{
            binding.saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a;
                    savedText = inputField.getText().toString();
                    if(!savedText.isEmpty()){
                        a = new Intent(MainActivity.this, Selectmenu.class);
                        a.putExtra("savedText", savedText);
                        startActivity(a);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);}
                }

            });
            binding.imageView2.setOnClickListener(v -> {
                //profile
                Intent a;
                savedText = inputField.getText().toString();
                a = new Intent(MainActivity.this, profile.class);
                a.putExtra("savedText", savedText);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
            binding.imageView3.setOnClickListener(v ->{
                //history
                Intent a;
                a = new Intent(MainActivity.this, SelectQuest.class);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
            binding.imageView.setOnClickListener(v ->{
                //BrainStorm
                Intent a;
                savedText = inputField.getText().toString();
                a = new Intent(MainActivity.this, BSselection.class);
                a.putExtra("savedText", savedText);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
        }
    }
}