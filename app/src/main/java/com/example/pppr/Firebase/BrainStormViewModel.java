package com.example.pppr.Firebase;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrainStormViewModel {
    private static BrainStormViewModel INSTANCE;
    private Context context;
    private String name;
    private DatabaseReference root;
    private MutableLiveData<ContentData> liveData = new MutableLiveData<>();
    private BrainStormViewModel(Context context, String name) {
        this.context = context;
        this.name = name;
        this.root = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        initListeners();
    }

    private void initListeners() {
        System.out.println(name);
        root.child("questions").child(name).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String, Content> contentMap = new HashMap<>();
                String name = "";
                String id = "";

                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    if ("name".equals(childSnapshot.getKey())) {
                        name = childSnapshot.getValue(String.class);
                    } else if ("id".equals(childSnapshot.getKey())) {
                        id = childSnapshot.getValue(String.class);
                    }
                    else {
                        Content content = childSnapshot.getValue(Content.class);
                        contentMap.put(childSnapshot.getKey(), content);
                    }
                }

                ContentData contentData = new ContentData(new ArrayList<>(contentMap.values()), name);
                liveData.postValue(contentData);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void saveContent(Content content) {

        root.child("questions").child(name).child(content.getId()).setValue(content)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Успешно сохранено", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

    public synchronized static BrainStormViewModel getInstance(Context context, String name) {
        if (INSTANCE == null || !INSTANCE.name.equals(name)) {
            INSTANCE = new BrainStormViewModel(context, name);
        }
        return INSTANCE;
    }



    public LiveData<ContentData> getUsersLiveData() {
        return liveData;
    }
}
