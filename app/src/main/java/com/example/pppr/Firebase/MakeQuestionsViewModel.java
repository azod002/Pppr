package com.example.pppr.Firebase;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeQuestionsViewModel {
    private static MakeQuestionsViewModel INSTANCE;
    private Context context;
    private String name;
    private DatabaseReference root;

    private MakeQuestionsViewModel(Context context, String name) {
        this.context = context;
        this.name = name;
        this.root = FirebaseDatabase.getInstance("https://pppr-c439f-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
    }

    public void saveQuestion(Question question) {

        root.child("questions").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(question)
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

    public static synchronized MakeQuestionsViewModel getInstance(Context context, String name) {
        if (INSTANCE == null) {
            INSTANCE = new MakeQuestionsViewModel(context, name);
        }
        return INSTANCE;
    }


}
