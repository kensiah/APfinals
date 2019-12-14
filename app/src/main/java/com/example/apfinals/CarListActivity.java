package com.example.apfinals;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;


import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

import org.json.JSONObject;

import java.io.IOException;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CarListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Car> data = new ArrayList<>();
    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        getDataFromAPI();
    }

    private void findViews(){
        listView = findViewById(R.id.listview);

        CarAdapter adapter = new CarAdapter(this,data);
        listView.setAdapter(adapter);
    }

    private void setListeners(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car selectedItem = (Car) listView.getAdapter().getItem(position);
                String model = selectedItem.getModel();
                Drawable image = selectedItem.getPicture();

                Intent i = new Intent(CarListActivity.this, CarVariantActivity.class);
                i.putExtra("model",model);
                startActivity(i);
            }
        });
    }

    private void initialize(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViews();
                setListeners();
            }
        });
    }

    private void getDataFromAPI(){
        Request request = new Request.Builder().url("https://api.myjson.com/bins/13e1kk").build();

        okHttpClient.newCall(request).enqueue(new Callback(){
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    JSONObject dataObject = new JSONObject(response.body().string());

                    JSONArray dataArray = dataObject.getJSONArray("cars");

                    for(int i =0; i < dataArray.length(); i++){
                        JSONObject singleObject = dataArray.getJSONObject(i);

                        Car model = new Car();
                        String modelName = singleObject.getString("model");
                        model.setBrand(singleObject.getString("brand"));
                        model.setModel(modelName);

                        switch(modelName.toUpperCase()){
                            case "X70":
                                model.setPicture(getDrawable(R.drawable.x70));
                                break;
                            case "SAGA":
                                model.setPicture(getDrawable(R.drawable.saga));
                                break;
                            case "PERSONA":
                                model.setPicture(getDrawable(R.drawable.persona));
                                break;
                            case "IRIZ":
                                model.setPicture(getDrawable(R.drawable.iriz));
                                break;
                            case "EXORA":
                                model.setPicture(getDrawable(R.drawable.exora));
                                break;
                            case "PERDANA":
                                model.setPicture(getDrawable(R.drawable.perdana));
                                break;
                            case "PREVE":
                                model.setPicture(getDrawable(R.drawable.preve));
                                break;
                        }

                        data.add(model);
                    }
                    initialize();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
