package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pppr.R;
import com.example.pppr.RecyclerView.MyAdapter;
import com.example.pppr.RecyclerView.NewAdapter;
import com.example.pppr.RecyclerView.OnHolderclicked;
import com.example.pppr.database.AppDatabase;
import com.example.pppr.database.DatabaseManager;
import com.example.pppr.database.Entity.MainEntity;
import com.example.pppr.databinding.ActivityListofNyBinding;

import java.util.ArrayList;
import java.util.List;

public class ListofNY_act extends AppCompatActivity {
    private AppDatabase database;

    private NewAdapter adapter2;
    private List<String> items1;


    private RecyclerView.LayoutManager layoutManager;
    private ActivityListofNyBinding binding;
    private int k = 0;

    private int VarNum = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListofNyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String savedtext = getIntent().getStringExtra("savedText");
        final EditText input = new EditText(ListofNY_act.this);

        database = DatabaseManager.getInstance(this).getDatabase();


        AlertDialog.Builder builder = new AlertDialog.Builder(ListofNY_act.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if (k == 1) {
                            MainEntity entity = new MainEntity(VarNum, k, userInput, savedtext);
                            adapter2.addNewEntity(entity);
                            database.getMainDao().insertMain(entity);
                        }
                    }
                });
        AlertDialog dialog = builder.create();
        initviews(input, dialog, savedtext, k, VarNum);


    }

    private void initviews(EditText input, AlertDialog dialog, String savedtext, int k, int VarNum) {
        binding.butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(" ");
                dialog.show();
                ListofNY_act.this.k = 1;
            }
        });
        binding.savedtext.setText(savedtext);
        initRecyclerView(savedtext, VarNum);
    }

    public void initRecyclerView(String savedtext, int VarNum) {
        List<MainEntity> entities2 = database.getMainDao().findallforView(savedtext, 2, VarNum);
        adapter2 = new NewAdapter(entities2, new OnHolderclicked() {
            @Override
            public void onRemoveClicked(MainEntity mainEntity) {
                database.getMainDao().delete(mainEntity);
            }
        });
        binding.recyclerView1.setAdapter(adapter2);

    }

}