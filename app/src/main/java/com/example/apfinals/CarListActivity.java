package com.example.apfinals;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

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

    private void initialize(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViews();
                setListeners();
            }
        });
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

                Intent i = new Intent(CarListActivity.this,CarDetailActivity.class);
                i.putExtra("brand",selectedItem.getBrand());
                i.putExtra("model",selectedItem.getModel());
                i.putExtra("variant",selectedItem.getVariant());
                i.putExtra("pricePM",selectedItem.getPricePm());
                i.putExtra("priceEM",selectedItem.getPriceEm());
                i.putExtra("priceLabuan",selectedItem.getPriceLabuan());
                i.putExtra("priceLangkawi",selectedItem.getPriceLangkawi());
                startActivity(i);
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
                        model.setBrand(singleObject.getString("brand"));
                        model.setModel(singleObject.getString("model"));
                        model.setVariant(singleObject.getString("variant"));
                        model.setPricePm(singleObject.getDouble("pricePM"));
                        model.setPriceEm(singleObject.getDouble("priceEM"));
                        model.setPriceLabuan(singleObject.getDouble("priceLabuan"));
                        model.setPriceLangkawi(singleObject.getDouble("priceLangkawi"));

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
