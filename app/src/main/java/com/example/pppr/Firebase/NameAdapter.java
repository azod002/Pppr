package com.example.pppr.Firebase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.R;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private List<Question> questions;
    private LayoutInflater inflater;
    private Context context;

    public NameAdapter(Context context, List<Question> questions) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.questions = questions;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.name_view_holder, parent, false);
        return new NameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.text_question.setText(question.getName());
        holder.text_id.setText(question.getId());
        holder.itemView.setOnClickListener(v -> {
            Intent a = new Intent(context, BrainStorm.class);
            a.putExtra("questionId", question.getId());
            context.startActivity(a);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {
        TextView text_question, text_id;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            text_question = itemView.findViewById(R.id.text_question);
            text_id = itemView.findViewById(R.id.text_id);
        }
    }
}


