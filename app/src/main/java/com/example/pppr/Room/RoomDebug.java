package com.example.pppr.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pppr.R;
import com.example.pppr.Room.Callbacks.OnContentClicked;
import com.example.pppr.Room.database.AppDatabase;
import com.example.pppr.Room.database.DatabaseManager;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.databinding.ActivityRoomNewBinding;

import java.util.List;

public class RoomDebug extends AppCompatActivity {
    private ActivityRoomNewBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    private AppDatabase database;
    private DBAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoomNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String question = getIntent().getStringExtra("savedText");


        System.out.println(question);
        initDatabase();
        initviews(question);
    }

    private void initDatabase() {database = DatabaseManager.getInstance(this).getDatabase();}

    private void initviews(String question) {
        System.out.println("STARTED");
        binding.saveButton.setOnClickListener(v -> {
            String content = binding.editText.getText().toString();
            if (content.isEmpty()) {
                Toast.makeText(this, "Введите содержимое новости", Toast.LENGTH_LONG).show();
                return;
            }
            binding.editText.setText("");

            ContentDB DB = new ContentDB(question, 1, 1, content);

            database.getContentDao().insert(DB);
            adapter.addNewPublication(DB);
        });
        initRecyclerView(question);
    }

    private void initRecyclerView(String q) {
        List<ContentDB> contentDBList = database.getContentDao().selectcontent(q, 1, 1);
        System.out.println(contentDBList);
        adapter = new DBAdapter(contentDBList, new OnContentClicked() {
            @Override
            public void onRemoveClicked(ContentDB contentDB) {
                database.getContentDao().delete(contentDB);
            }

            @Override
            public void onJustClicked(ContentDB contentDB){
            }
        });
        layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }
}