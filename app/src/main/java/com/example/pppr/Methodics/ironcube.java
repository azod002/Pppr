package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pppr.R;

public class ironcube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ironcube);

        String savedtext = getIntent().getStringExtra("savedText");

        int minValue = 0;
        int maxValue = 7;
        int a = minValue + (int) (Math.random() * (maxValue - minValue + 1));
        String[] arr = new String[10];
        arr = new String[]{"Мне кажется — «да»", "Никаких сомнений", "Очень сомнительно", "Сконцентрируйся и спроси опять", "Сейчас нельзя предсказать", "Да", "Можешь быть уверен в этом", "По моим данным — «нет»"};

        TextView view1 = findViewById(R.id.view1);
        TextView view2 = findViewById(R.id.view2);
        Button back = findViewById(R.id.backButton);

        view1.setText(arr[a]);
        view2.setText(savedtext);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.page_turn_out_reverse, R.anim.page_turn_in_reverse);
            }
        });



    }
}