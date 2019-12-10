package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;



public class CarListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Car> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        findViews();
    }

    private void findViews(){
        listView = (ListView)findViewById(R.id.listview);
    }


}
