package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class CarListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Car> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        findViews();
        ArrayList<HashMap<String,String>> carList = new ArrayList<HashMap<String, String>>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray("cars");
            HashMap<String, String> hashMap;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String brand = jsonObject.getString("brand");
                String model = jsonObject.getString("model");
                String variant = jsonObject.getString("variant");
                double pricePM = jsonObject.getDouble("pricePM");
                double priceEM = jsonObject.getDouble("priceEM");
                double priceLabuan = jsonObject.getDouble("priceLabuan");
                double priceLangkawi = jsonObject.getDouble("priceLangkawi");

                hashMap = new HashMap<String, String>();
                hashMap.put("brand", brand);
                hashMap.put("model", model);
                hashMap.put("variant", variant);
                hashMap.put("pricePM", Double.toString(pricePM));
                hashMap.put("priceEM", Double.toString(priceEM));
                hashMap.put("priceLabuan", Double.toString(priceLabuan));
                hashMap.put("priceLangkawi", Double.toString(priceLangkawi));

                data.add(hashMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findViews(){
        listView = findViewById(R.id.listview);
    }

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = (CarListActivity.this).getAssets().open("brand_price.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}
