package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.RecyclerView.MyAdapter;
import com.example.pppr.R;

import java.util.ArrayList;
import java.util.List;

public class dekartsquare extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView recyclerView4;
    private MyAdapter adapter1;
    private MyAdapter adapter2;
    private MyAdapter adapter3;
    private MyAdapter adapter4;
    private List<String> items1;
    private List<String> items2;
    private List<String> items3;
    private List<String> items4;
    private int k = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekartsquare);
        String savedtext = getIntent().getStringExtra("savedText");


        recyclerView1 = findViewById(R.id.recycler_view1);
        recyclerView2 = findViewById(R.id.recycler_view2);
        recyclerView3 = findViewById(R.id.recycler_view3);
        recyclerView4 = findViewById(R.id.recycler_view4);
        TextView view = findViewById(R.id.textView);
        Button butt1 = findViewById(R.id.button1);
        Button butt2 = findViewById(R.id.button2);
        Button butt3 = findViewById(R.id.button3);
        Button butt4 = findViewById(R.id.button4);
        final EditText input = new EditText(dekartsquare.this);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));
        Button back = findViewById(R.id.backButton);

        view.setText(savedtext);
        items1 = new ArrayList<>();
        items2 = new ArrayList<>();
        items3 = new ArrayList<>();
        items4 = new ArrayList<>();
        items1.add("Сильные стороны");
        items2.add("Недостатки");
        items3.add("Возможности");
        items4.add("Угрозы");

        adapter1 = new MyAdapter(items1);
        recyclerView1.setAdapter(adapter1);
        adapter2 = new MyAdapter(items2);
        recyclerView2.setAdapter(adapter2);
        adapter3 = new MyAdapter(items3);
        recyclerView3.setAdapter(adapter3);
        adapter4 = new MyAdapter(items4);
        recyclerView4.setAdapter(adapter4);


        AlertDialog.Builder builder = new AlertDialog.Builder(dekartsquare.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if (k == 1) adapter1.addItem(userInput);
                        else if (k == 2) adapter2.addItem(userInput);
                        else if (k == 3) adapter3.addItem(userInput);
                        else if (k == 4) adapter4.addItem(userInput);
                    }
                });
        AlertDialog dialog = builder.create();


        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k = 1;
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k = 2;
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k = 3;
            }
        });
        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k = 4;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
    }
}
