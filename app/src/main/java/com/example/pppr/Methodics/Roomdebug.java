package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pppr.RecyclerView.NewAdapter;
import com.example.pppr.RecyclerView.OnHolderclicked;
import com.example.pppr.database.AppDatabase;
import com.example.pppr.database.DatabaseManager;
import com.example.pppr.database.Entity.MainEntity;
import com.example.pppr.databinding.ActivityRoomdebugBinding;
import com.example.pppr.databinding.ActivityRoomdebugBinding;

import java.util.List;

public class Roomdebug extends AppCompatActivity {
    private AppDatabase database;

    private NewAdapter adapter2;
    private List<String> items1;


    private RecyclerView.LayoutManager layoutManager;
    private ActivityRoomdebugBinding binding;
    private int k = 0;

    private int VarNum = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoomdebugBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String savedtext = getIntent().getStringExtra("savedText");
        final EditText input = new EditText(Roomdebug.this);

        database = DatabaseManager.getInstance(this).getDatabase();


        AlertDialog.Builder builder = new AlertDialog.Builder(Roomdebug.this);
        builder.setMessage("")
                .setTitle("Введите текст")
                .setView(input)
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String userInput = input.getText().toString();
                        if (k == 1) {
                            MainEntity entity = new MainEntity(VarNum, k, userInput, savedtext);
                            database.getMainDao().insertMain(entity);
                            adapter2.addNewEntity(entity);
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
                Roomdebug.this.k = 1;
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
        layoutManager = new LinearLayoutManager(this);
        binding.recyclerView1.setLayoutManager(layoutManager);
        binding.recyclerView1.setAdapter(adapter2);

    }

}