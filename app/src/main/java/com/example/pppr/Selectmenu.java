package com.example.pppr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pppr.MegaAnalis.MegaAnalis;
import com.example.pppr.Methodics.AnsFromTime;
import com.example.pppr.Methodics.MPK;
import com.example.pppr.Methodics.ironcube;
import com.example.pppr.Methodics.dekartsquare;
import com.example.pppr.Methodics.ZauProtiv;
import com.example.pppr.Methodics.Tens;
import com.example.pppr.Methodics.RealDekart;
import com.example.pppr.databinding.ActivitySelectmenuBinding;

public class Selectmenu extends AppCompatActivity {
    private ActivitySelectmenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectmenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String savedtext = getIntent().getStringExtra("savedText");



        binding.View.setText(savedtext);

        binding.var1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(Selectmenu.this, dekartsquare.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        binding.var2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(Selectmenu.this, ironcube.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.page_turn_in, R.anim.page_turn_out);

            }
        });
        binding.var3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(Selectmenu.this, Tens.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        binding.var4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(Selectmenu.this, ZauProtiv.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        binding.var5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(Selectmenu.this, MPK.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        binding.var6.setOnClickListener(v -> {
            Intent a;
            a = new Intent(Selectmenu.this, AnsFromTime.class);
            a.putExtra("savedText", savedtext);
            startActivity(a);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        binding.var7.setOnClickListener(v -> {
            Intent a;
            a = new Intent(Selectmenu.this, RealDekart.class);
            a.putExtra("savedText", savedtext);
            startActivity(a);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        binding.MegaAnalis.setOnClickListener(v -> {
            Intent a;
            a = new Intent(Selectmenu.this, MegaAnalis.class);
            a.putExtra("savedText", savedtext);
            startActivity(a);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });



    }
}