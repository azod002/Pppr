package com.example.pppr.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.Firebase.Content;
import com.example.pppr.R;
import com.example.pppr.Room.Callbacks.OnContentClicked;
import com.example.pppr.Room.database.Entity.ContentDB;
import com.example.pppr.databinding.DbViewHolderBinding;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.DBViewHolder> {

    private List<ContentDB> contentDB = new ArrayList<>();
    private OnContentClicked callback;

    public DBAdapter(List<ContentDB> contentDB, OnContentClicked callback) {
        this.contentDB = contentDB;
        this.callback = callback;
    }

    @NonNull
    @Override
    public DBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.db_view_holder, parent, false);
        return new DBViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull DBViewHolder holder, int position) {
        holder.update(contentDB.get(position));
    }

    @Override
    public int getItemCount() {return contentDB.size();}

    public void addNewPublication(ContentDB DB) {
        contentDB.add(DB);
        notifyItemInserted(contentDB.size() - 1);
    }

    public class DBViewHolder extends RecyclerView.ViewHolder {
        private DbViewHolderBinding binding;
        public DBViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =DbViewHolderBinding.bind(itemView);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ContentDB content = contentDB.get(getAdapterPosition());
                    callback.onJustClicked(content);
                }
            });
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    ContentDB content = contentDB.get(getAdapterPosition());
                    contentDB.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    callback.onRemoveClicked(content);
                    return false;
                }
            });
        }

        public void update(ContentDB contentDB) {
            binding.textContent.setText(contentDB.getContent());
        }
    }
}
