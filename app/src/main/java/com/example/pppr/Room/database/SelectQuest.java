package com.example.pppr.Room.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.pppr.MainActivity;
import com.example.pppr.R;
import com.example.pppr.Room.Callbacks.OnContentClicked;
import com.example.pppr.Room.DBAdapter;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.Selectmenu;
import com.example.pppr.databinding.ActivitySelectQuestBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectQuest extends AppCompatActivity {
    private ActivitySelectQuestBinding binding;
    private AppDatabase database;
    private DBAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectQuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initDatabase();
        initRecyclerView();


    }

    private void initRecyclerView() {
        List<ContentDB> contentDBList = database.getContentDao().findAll();

        List<ContentDB> uniqueContentDBList = new ArrayList<>();
        Map<String, ContentDB> uniqueQuestions = new HashMap<>();
        System.out.println(contentDBList);
        for (ContentDB contentDB : contentDBList) {
            String question = contentDB.getQuestion();
            if (question != null && !question.trim().isEmpty() && !uniqueQuestions.containsKey(question)) {
                uniqueQuestions.put(question, contentDB);
                uniqueContentDBList.add(contentDB);
            }
        }
        //да это костыль т.к. можно просто сразу запросом это получить, но у меня вылазит ошибка

        for (ContentDB contentDB : uniqueContentDBList) {
            String question = contentDB.getQuestion();
            contentDB.setContent(question);
        }
        System.out.println(uniqueContentDBList);



        adapter = new DBAdapter(uniqueContentDBList, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
                //ЗДЕСЬ НАДО СДЕЛАТЬ ТАК ЧТОБЫ ОНО УДАЛЯЛО ВСЕ С question'ом ИЗ БД

            }

            @Override
            public void onJustClicked(ContentDB contentDB){
                String question = contentDB.getQuestion();
                Intent a;
                a = new Intent(SelectQuest.this, Selectmenu.class);
                a.putExtra("savedText", question);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    private void initDatabase() {database = DatabaseManager.getInstance(this).getDatabase();}
}