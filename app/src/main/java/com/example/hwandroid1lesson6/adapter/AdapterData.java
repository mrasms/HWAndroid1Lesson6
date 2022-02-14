package com.example.hwandroid1lesson6.adapter;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwandroid1lesson6.adapter.listener.OnClickListener;
import com.example.hwandroid1lesson6.databinding.ListHolderBinding;
import com.example.hwandroid1lesson6.list_model.ListModel;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    public ArrayList<ListModel> list = new ArrayList<>();
    OnClickListener onClickListener;

    public void setOnItemClickListener(OnClickListener onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderData(ListHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addData(ListModel listModel) {
        this.list.add(listModel);
        notifyDataSetChanged();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        private ListHolderBinding binding;

        public HolderData(@NonNull ListHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ListModel listModel) {
            binding.tvValue.setText(listModel.getData());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onItemClickListener(getAdapterPosition(), listModel);
                }
            });

        }
    }
}