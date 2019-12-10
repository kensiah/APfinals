package com.example.apfinals;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter {
    private ArrayAdapter<Car> data;
    private Context context;

    public CarAdapter(Context context, ArrayList<Car> data){
        super(context,R.layout.activity_car_list);
    }
}
