package com.example.hwandroid1lesson6.list_model;

import static com.example.hwandroid1lesson6.R.id.tv_value;

import android.widget.TextView;

import com.example.hwandroid1lesson6.R;

import java.io.Serializable;
import java.util.ArrayList;

import java.io.Serializable;

public class ListModel implements Serializable {
    private  String title;

    public ListModel(String title) {
        this.title = title;
    }

    public String getData() {
        return title;
    }

    public void setData(String data) {
        this.title = data;
    }
}
