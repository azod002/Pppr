package com.example.pppr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pppr.Methodics.Var1;
import com.example.pppr.Methodics.Var2_1;
import com.example.pppr.Methodics.Var4;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String savedtext = getIntent().getStringExtra("savedText");
        Button back = findViewById(R.id.backButton);
        Button var1 = findViewById(R.id.var1);
        Button var2 = findViewById(R.id.var2);
        Button var3 = findViewById(R.id.var3);
        Button var4 = findViewById(R.id.var4);
        TextView view = findViewById(R.id.View);

        view.setText(savedtext);

        var1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(MainActivity2.this, Var1.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.page_turn_in, R.anim.page_turn_out);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        var2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(MainActivity2.this, Var2_1.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        var3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(MainActivity2.this, com.example.pppr.Methodics.var3.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        var4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a;
                a = new Intent(MainActivity2.this, Var4.class);
                a.putExtra("savedText", savedtext);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });



    }
}