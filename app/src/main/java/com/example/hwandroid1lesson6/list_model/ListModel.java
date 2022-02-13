package com.example.hwandroid1lesson6.list_model;

import static com.example.hwandroid1lesson6.R.id.tv_value;

import android.widget.TextView;

import com.example.hwandroid1lesson6.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ListModel implements Serializable {
    public static ArrayList<ListModel> listModel = new ArrayList<>();

    public String getList() {
        return list;
    }

    private String list;
    public static ArrayList<ListModel> getListModel(){
        listModel.add(new ListModel());
        return listModel;
    }
}

