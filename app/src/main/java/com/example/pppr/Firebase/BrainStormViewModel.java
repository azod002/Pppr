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
import java.util.List;
import java.util.Map;

public class BrainStormViewModel {
    private static BrainStormViewModel INSTANCE;
    private Context context;
    private DatabaseReference root;
    private MutableLiveData<List<Content>> liveData = new MutableLiveData<>();
    private BrainStormViewModel(Context context) {
        this.context = context;
        this.root = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        initListeners();
    }

    private void initListeners() {
        root.child("questions").child("question1").addValueEventListener(new ValueEventListener() {
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

    public void saveContent(Content content) {
        root.child("questions").child("question1").child(content.getId()).setValue(content)
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

    public synchronized static BrainStormViewModel getInstance(Context context) {
        if (INSTANCE == null) INSTANCE = new BrainStormViewModel(context);
        return INSTANCE;
    }

    public LiveData<List<Content>> getUsersLiveData() {
        return liveData;
    }
}
