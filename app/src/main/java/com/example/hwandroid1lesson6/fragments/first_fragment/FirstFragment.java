package com.example.hwandroid1lesson6.fragments.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwandroid1lesson6.R;
import com.example.hwandroid1lesson6.databinding.FragmentFirstBinding;
import com.example.hwandroid1lesson6.fragments.second_fragment.SecondFragment;
import com.example.hwandroid1lesson6.fragments.third_fragment.ThirdFragment;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

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


    private void setupListener() {
        binding.btnOpenToSecondFragment.setOnClickListener(view -> {
            ThirdFragment thirdFragment = new ThirdFragment();
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, thirdFragment).commit();
        });
    }

    private void getData() {
        if (getArguments() != null) {
            String getMessage = getArguments().getString("sendMessage");
            .setText(getMessage);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}