package com.example.pppr.Firebase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BSselViewModel {
    private static BSselViewModel INSTANCE;
    private Context context;
    private DatabaseReference root;
    private MutableLiveData<List<Content>> liveData = new MutableLiveData<>();
    private BSselViewModel(Context context) {
        this.context = context;
        this.root = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        initListeners();
    }

    private void initListeners() {
        root.child("questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String, Content> map = snapshot.getValue(new GenericTypeIndicator<Map<String, Content>>() {});
                System.out.println(snapshot);
                liveData.postValue(new ArrayList<>(map.values()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
