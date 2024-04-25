package com.example.pppr.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pppr.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    Button deleteButton;

    MyViewHolder(View itemView, final MyAdapter adapter) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_note);
        deleteButton = itemView.findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    adapter.removeItem(position);

                }
            }
        });
    }
}
