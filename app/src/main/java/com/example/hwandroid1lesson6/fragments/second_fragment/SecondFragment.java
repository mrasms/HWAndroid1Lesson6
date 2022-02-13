package com.example.hwandroid1lesson6.fragments.second_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwandroid1lesson6.R;
import com.example.hwandroid1lesson6.databinding.FragmentSecondBinding;
import com.example.hwandroid1lesson6.fragments.first_fragment.FirstFragment;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class SecondFragment extends Fragment {
    FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListener();
    }

    private void setupListener() {
        binding.btnSendMessage.setOnClickListener(new View.OnClickListener() {
            TextView textView = (TextView) binding.tvTimer;
            CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView.setText(String.format(Locale.getDefault(), "%d ", millisUntilFinished / 1000L));
                }

                public void onFinish() {
                    textView.setText("");
                    String message = binding.etInputText.getText().toString().trim();
                    Bundle bundle = new Bundle();
                    bundle.putString("sendMessage", message);
                    FirstFragment firstFragment = new FirstFragment();
                    firstFragment.setArguments(bundle);
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).commit();
                }
            };


            @Override
            public void onClick(View view) {

                countDownTimer.start();


            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}