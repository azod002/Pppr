package com.example.pppr.Firebase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
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

    private MutableLiveData<List<Question>> questionsLiveData = new MutableLiveData<>();
    private DatabaseReference databaseReference;

    public BSselViewModel() {
        databaseReference = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("questions");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Question> questionsList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Question question = snapshot.getValue(Question.class);
                    if (question != null && question.getName() != null) {
                        questionsList.add(question);
                    }
                }
                questionsLiveData.setValue(questionsList); // Обновляем LiveData
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Обработка ошибок доступа к базе данных
            }
        });
    }

    public void deleteUserQuestion() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Question question = snapshot.getValue(Question.class);
                    if (question != null && question.getId() != null && question.getId().equals(FirebaseAuth.getInstance().getUid())) {
                        snapshot.getRef().removeValue(); // Удаляем вопрос
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Обработка ошибок доступа к базе данных
            }
        });
    }

    public LiveData<List<Question>> getQuestions() { return questionsLiveData; }
}


