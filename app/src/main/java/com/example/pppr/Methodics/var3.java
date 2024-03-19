package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pppr.RecyclerView.MyAdapter;
import com.example.pppr.R;
import com.example.pppr.databinding.ActivityVar3Binding;

import java.util.ArrayList;
import java.util.List;

public class var3 extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private MyAdapter adapter1;
    private MyAdapter adapter2;
    private MyAdapter adapter3;
    private List<String> items1;
    private List<String> items2;
    private List<String> items3;
    private int k=0;

    private ActivityVar3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVar3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String savedtext = getIntent().getStringExtra("savedText");

        Button butt1 = findViewById(R.id.butt1);
        Button butt2 = findViewById(R.id.butt2);
        Button butt3 = findViewById(R.id.butt3);
        Button back = findViewById(R.id.backButton);
        recyclerView1 = findViewById(R.id.recycler_view1);
        recyclerView2 = findViewById(R.id.recycler_view2);
        recyclerView3 = findViewById(R.id.recycler_view3);
        TextView quest = findViewById(R.id.quest);
        TextView Savedtext = findViewById(R.id.savedtext);
        final EditText input = new EditText(var3.this);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));





        items1 = new ArrayList<>();
        items2 = new ArrayList<>();
        items3 = new ArrayList<>();
        items1.add("10 минут");
        items2.add("10 часов");
        items3.add("10 лет");
        adapter1 = new MyAdapter(items1);
        recyclerView1.setAdapter(adapter1);
        adapter2 = new MyAdapter(items2);
        recyclerView2.setAdapter(adapter2);
        adapter3 = new MyAdapter(items3);
        recyclerView3.setAdapter(adapter3);

        AlertDialog.Builder builder = new AlertDialog.Builder(var3.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if     (k==1)adapter1.addItem(userInput);
                        else if(k==2)adapter2.addItem(userInput);
                        else if(k==3)adapter3.addItem(userInput);
                    }
                });
        AlertDialog dialog = builder.create();
        Savedtext.setText(savedtext);


        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k=1;
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k=2;
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                k=3;
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