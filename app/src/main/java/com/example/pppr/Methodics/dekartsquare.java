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
import com.example.pppr.Room.Callbacks.OnContentClicked;
import com.example.pppr.Room.DBAdapter;
import com.example.pppr.Room.database.AppDatabase;
import com.example.pppr.Room.database.DatabaseManager;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.databinding.ActivityDekartsquareBinding;

import java.util.ArrayList;
import java.util.List;

public class dekartsquare extends AppCompatActivity {

    private ActivityDekartsquareBinding binding;
    private int k = 0;
    private DBAdapter adapter1;
    private DBAdapter adapter2;
    private DBAdapter adapter3;
    private DBAdapter adapter4;
    private RecyclerView.LayoutManager layoutManager1;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;
    private RecyclerView.LayoutManager layoutManager4;
    private AppDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDekartsquareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String savedtext = getIntent().getStringExtra("savedText");

        final EditText input = new EditText(dekartsquare.this);

        initDatabase();
        binding.textView.setText(savedtext);

        AlertDialog.Builder builder = new AlertDialog.Builder(dekartsquare.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if (k == 1){
                            System.out.println(savedtext + "      " + userInput);
                            ContentDB content = new ContentDB(savedtext, 1, 1, userInput);
                            database.getContentDao().insert(content);
                            adapter1.addNewPublication(content);
                            input.setText("");
                        }
                        else if (k == 2){
                            System.out.println(savedtext + "      " + userInput);
                            ContentDB content = new ContentDB(savedtext, 1, 2, userInput);
                            database.getContentDao().insert(content);
                            adapter2.addNewPublication(content);
                            input.setText("");
                        }
                        else if (k == 3){
                            ContentDB content = new ContentDB(savedtext, 1, 3, userInput);
                            database.getContentDao().insert(content);
                            adapter3.addNewPublication(content);
                            input.setText("");
                        }
                        else if (k == 4){
                            ContentDB content = new ContentDB(savedtext, 1, 4, userInput);
                            database.getContentDao().insert(content);
                            adapter4.addNewPublication(content);
                            input.setText("");
                        }
                    }
                });
        initRecyclerView(savedtext);
        AlertDialog dialog = builder.create();
        binding.button1.setOnClickListener(v -> {
            dialog.show();
            k = 1;
        });
        binding.button2.setOnClickListener(v -> {
            dialog.show();
            k = 2;
        });
        binding.button3.setOnClickListener(v -> {
            dialog.show();
            k = 3;
        });
        binding.button4.setOnClickListener(v -> {
            dialog.show();
            k = 4;
        });
        binding.backButton.setOnClickListener(v -> {
            finish();
        });



    }

    private void initRecyclerView(String savedtext) {
        List<ContentDB> contentDBList1 = database.getContentDao().selectcontent(savedtext, 1, 1);
        List<ContentDB> contentDBList2 = database.getContentDao().selectcontent(savedtext, 1, 2);
        List<ContentDB> contentDBList3 = database.getContentDao().selectcontent(savedtext, 1, 3);
        List<ContentDB> contentDBList4 = database.getContentDao().selectcontent(savedtext, 1, 4);

        adapter1 = new DBAdapter(contentDBList1, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
            }

            @Override
            public void onJustClicked(ContentDB contentDB) {
            }
        });
        adapter2 = new DBAdapter(contentDBList2, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
            }

            @Override
            public void onJustClicked(ContentDB contentDB) {
            }
        });
        adapter3 = new DBAdapter(contentDBList3, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
            }

            @Override
            public void onJustClicked(ContentDB contentDB) {
            }
        });
        adapter4 = new DBAdapter(contentDBList4, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
            }

            @Override
            public void onJustClicked(ContentDB contentDB) {
            }
        });

        layoutManager1 = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager3 = new LinearLayoutManager(this);
        layoutManager4 = new LinearLayoutManager(this);
        binding.recyclerView1.setLayoutManager(layoutManager1);
        binding.recyclerView1.setAdapter(adapter1);
        binding.recyclerView2.setLayoutManager(layoutManager2);
        binding.recyclerView2.setAdapter(adapter2);
        binding.recyclerView3.setLayoutManager(layoutManager3);
        binding.recyclerView3.setAdapter(adapter3);
        binding.recyclerView4.setLayoutManager(layoutManager4);
        binding.recyclerView4.setAdapter(adapter4);
    }


    private void initDatabase() {database = DatabaseManager.getInstance(this).getDatabase();}
}
