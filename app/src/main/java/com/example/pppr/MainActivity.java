package com.example.pppr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pppr.Auth.Register;
import com.example.pppr.Methodics.ListofNY_act;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText inputField;
    private String savedText;

    private boolean areFabsVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputField = findViewById(R.id.inputField);
        Button saveButton = findViewById(R.id.saveButton);
        FloatingActionButton mainFab = findViewById(R.id.main_fab);
        FloatingActionButton childFab1 = findViewById(R.id.child_fab_1);
        FloatingActionButton childFab2 = findViewById(R.id.child_fab_2);
        FloatingActionButton childFab3 = findViewById(R.id.child_fab_3);


        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            Intent a;
            a = new Intent(MainActivity.this, Register.class);
            startActivity(a);
            finish();
        }
        else{
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a;
                    savedText = inputField.getText().toString();
                    a = new Intent(MainActivity.this, MainActivity2.class);
                    a.putExtra("savedText", savedText);
                    startActivity(a);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

            });
            mainFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    areFabsVisible = !areFabsVisible;
                    childFab1.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
                    childFab2.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
                    childFab3.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);                }
            });
            childFab2.setOnClickListener(v -> {
                Intent a;
                savedText = inputField.getText().toString();
                a = new Intent(MainActivity.this, ListofNY_act.class);
                a.putExtra("savedText", savedText);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });
        }
    }
}