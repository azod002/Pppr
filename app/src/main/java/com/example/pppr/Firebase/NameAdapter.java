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

    private List<String> names;
    private LayoutInflater inflater;
    private Context context;
    public NameAdapter(Context context, List<String> names) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.names = names;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.name_view_holder, parent, false);
        return new NameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        String name = names.get(position);
        holder.text_question.setText(name);
        holder.itemView.setOnClickListener(v -> {
            Intent a = new Intent(context, BrainStorm.class);
            a.putExtra("name", name);
            context.startActivity(a);
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {
        TextView text_question;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            text_question = itemView.findViewById(R.id.text_question);
        }

        public void update(String name) {
            text_question.setText(name);
        }
    }
}

