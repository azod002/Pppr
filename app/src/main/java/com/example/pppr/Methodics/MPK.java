package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pppr.R;
import com.example.pppr.Room.Callbacks.OnContentClicked;
import com.example.pppr.Room.DBAdapter;
import com.example.pppr.Room.database.AppDatabase;
import com.example.pppr.Room.database.DatabaseManager;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.databinding.ActivityMpkBinding;

import java.util.List;

public class MPK extends AppCompatActivity {
    private DBAdapter adapter1;
    private DBAdapter adapter2;
    private DBAdapter adapter3;
    private RecyclerView.LayoutManager layoutManager1;
    private RecyclerView.LayoutManager layoutManager2;
    private RecyclerView.LayoutManager layoutManager3;
    private AppDatabase database;
    private int k=0;
    private ActivityMpkBinding binding;
    private boolean areFabsVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMpkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String savedtext = getIntent().getStringExtra("savedText");
        final EditText input = new EditText(MPK.this);

        initDatabase();
        binding.savedtext.setText(savedtext);

        AlertDialog.Builder builder = new AlertDialog.Builder(MPK.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if (k == 1){
                            System.out.println(savedtext + "      " + userInput);
                            ContentDB content = new ContentDB(savedtext, 5, 1, userInput);
                            database.getContentDao().insert(content);
                            adapter1.addNewPublication(content);
                            input.setText("");
                        }
                        else if (k == 2){
                            System.out.println(savedtext + "      " + userInput);
                            ContentDB content = new ContentDB(savedtext, 5, 2, userInput);
                            database.getContentDao().insert(content);
                            adapter2.addNewPublication(content);
                            input.setText("");
                        }
                        else if (k == 3){
                            ContentDB content = new ContentDB(savedtext, 5, 3, userInput);
                            database.getContentDao().insert(content);
                            adapter3.addNewPublication(content);
                            input.setText("");
                        }

                    }
                });
        AlertDialog dialog = builder.create();
        initRecyclerView(savedtext);


        binding.butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                k=1;
            }
        });
        binding.butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                k=2;
            }
        });
        binding.butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                k=3;
            }
        });
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
        binding.questbutt.setOnClickListener(v -> {
            areFabsVisible = !areFabsVisible;
            binding.ans.setVisibility(areFabsVisible ? View.VISIBLE : View.GONE);
        });

    }


    private void initRecyclerView(String savedtext) {
        List<ContentDB> contentDBList1 = database.getContentDao().selectcontent(savedtext, 5, 1);
        List<ContentDB> contentDBList2 = database.getContentDao().selectcontent(savedtext, 5, 2);
        List<ContentDB> contentDBList3 = database.getContentDao().selectcontent(savedtext, 5, 3);


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


        layoutManager1 = new LinearLayoutManager(this);
        layoutManager2 = new LinearLayoutManager(this);
        layoutManager3 = new LinearLayoutManager(this);

        binding.recyclerView1.setLayoutManager(layoutManager1);
        binding.recyclerView1.setAdapter(adapter1);
        binding.recyclerView2.setLayoutManager(layoutManager2);
        binding.recyclerView2.setAdapter(adapter2);
        binding.recyclerView3.setLayoutManager(layoutManager3);
        binding.recyclerView3.setAdapter(adapter3);
    }

    private void initDatabase() {database = DatabaseManager.getInstance(this).getDatabase();}
}