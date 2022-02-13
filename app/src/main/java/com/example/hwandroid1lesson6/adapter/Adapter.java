package com.example.hwandroid1lesson6.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwandroid1lesson6.R;
import com.example.hwandroid1lesson6.list_model.ListModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListHolder> {
    ArrayList<ListModel> list = new ArrayList<>();

    public Adapter(ArrayList<ListModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_holder, parent, false);

        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ListHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {
        TextView tvValue;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            tvValue = itemView.findViewById(R.id.tv_value);
        }

        public void onBind(ListModel listModel) {
            tvValue.setText(listModel.getListModel().toString());
        }
    }
}


