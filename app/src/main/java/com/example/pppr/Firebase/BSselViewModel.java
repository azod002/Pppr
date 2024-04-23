package com.example.pppr.Firebase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BSselViewModel extends ViewModel {

    private MutableLiveData<List<String>> namesLiveData = new MutableLiveData<>();
    private DatabaseReference databaseReference;

    public BSselViewModel() {
        databaseReference = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("questions");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> namesList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("name").getValue(String.class);
                    if (name != null) {
                        namesList.add(name);
                    }
                }
                namesLiveData.setValue(namesList); // Обновляем LiveData
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Обработка возможных ошибок, например, отсутствие доступа к базе данных
            }
        });
    }

    public LiveData<List<String>> getNames() {return namesLiveData;}
}

