package com.example.pppr.Firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.R;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private List<Content> contents = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public ContentAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContentViewHolder(inflater.inflate(R.layout.content_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        holder.update(contents.get(position));
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    public void update(List<Content> contents) {
        this.contents = contents;
        notifyDataSetChanged();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView textId, textContent;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            textId = itemView.findViewById(R.id.text_id);
            textContent = itemView.findViewById(R.id.text_content);
        }

        public void update(Content content) {
            textId.setText(content.getId());
            textContent.setText(content.getContent());

        }
    }
}
