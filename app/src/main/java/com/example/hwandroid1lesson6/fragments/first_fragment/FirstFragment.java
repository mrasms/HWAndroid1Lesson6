package com.example.hwandroid1lesson6.fragments.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwandroid1lesson6.R;
import com.example.hwandroid1lesson6.adapter.AdapterData;
import com.example.hwandroid1lesson6.adapter.listener.OnClickListener;
import com.example.hwandroid1lesson6.databinding.FragmentFirstBinding;
import com.example.hwandroid1lesson6.fragments.second_fragment.SecondFragment;
import com.example.hwandroid1lesson6.fragments.third_fragment.ThirdFragment;
import com.example.hwandroid1lesson6.list_model.ListModel;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    AdapterData adapter;
    ListModel listModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
        getData();


    }

/*
    private void setupListener() {
        binding.btnOpenToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, secondFragment).commit();
            }

        });

        */
/*adapter.setOnItemClickListener (new OnClickListener() {
            @Override
        public void onItemClickListener(int position, ListModel listModel) {
                ThirdFragment thirdFragment = new ThirdFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, thirdFragment).commit();
                ListModel listmodel = new ListModel(adapter.list.get(position).getData());
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", listmodel);
                thirdFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, thirdFragment).commit();


            }
        });*//*

    }
*/

        /*adapter.setOnItemClickListener (new OnClickListener() {
            @Override
        public void onItemClickListener(int position, ListModel listModel) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, secondFragment).commit();
                ListModel listmodel = new ListModel(adapter.list.get(position).getData());
                Bundle bundle = new Bundle();
                bundle.putSerializable("sendMessage", listmodel);
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, secondFragment).commit();


            }
        });
    }*/

    private void setupListener() {
        binding.btnOpenToSecondFragment.setOnClickListener(view -> {
            ThirdFragment thirdFragment = new ThirdFragment();
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thirdFragment).commit();
        });
    }
    private void getData() {
        adapter = new AdapterData();
        binding.listRecycler.setAdapter(adapter);
        if (getArguments() != null) {
            ListModel listModel = (ListModel)getArguments().getSerializable("sendMessage");
            adapter.addData(listModel);
        }


    }

/*    private void getData() {
        if (getArguments() != null) {
            String getMessage = getArguments().getString("sendMessage");
            binding.list.findViewHolderForItemId(R.id.tv_value);
        }
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}