package com.example.hwandroid1lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hwandroid1lesson6.databinding.ActivityMainBinding;
import com.example.hwandroid1lesson6.fragments.first_fragment.FirstFragment;
import com.example.hwandroid1lesson6.fragments.second_fragment.SecondFragment;
import com.example.hwandroid1lesson6.fragments.third_fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, ThirdFragment.class,null).commit();
        }
    }
}