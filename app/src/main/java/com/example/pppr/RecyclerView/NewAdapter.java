package com.example.pppr.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.R;
import com.example.pppr.database.AppDatabase;
import com.example.pppr.database.DatabaseManager;
import com.example.pppr.database.Entity.MainEntity;
import com.example.pppr.databinding.NewitemBinding;


import java.util.ArrayList;
import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {

    private List<MainEntity> entities = new ArrayList<>();
    private OnHolderclicked callback;

    public NewAdapter(List<MainEntity> entities, OnHolderclicked callback) {
        this.entities = entities;
        this.callback = callback;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newviewholder, parent, false);
        return new NewViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        MainEntity entity = entities.get(position);
        holder.update(entity);
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public void addNewEntity(MainEntity entity) {
        entities.add(entity);
        notifyItemInserted(entities.size() - 1);
    }

    class NewViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewContent;
        Button buttonLike, buttonDelete;
        private NewitemBinding binding;



        NewViewHolder(View itemView, NewAdapter adapter) {
            super(itemView);
            binding = NewitemBinding.bind(itemView);
            buttonDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    MainEntity entity = entities.get(position);
                    if (adapter.callback != null) {
                        adapter.callback.onRemoveClicked(entity);
                    }
                }
            });

        }

        public void update(MainEntity entity) {
            TextView title = itemView.findViewById(R.id.title_note);
            title.setText(entity.getContent());
        }
    }
}
