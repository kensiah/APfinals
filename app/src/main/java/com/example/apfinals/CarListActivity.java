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

    public static String AssetJSONFile (String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        findViews();
        ArrayList<HashMap<String,String>> carList = new ArrayList<HashMap<String, String>>();
        Context context = null;
        try{
            String jsonLocation = AssetJSONFile("brand_price.json",context);
            JSONObject carArray = (new JSONObject()).getJSONObject("cars");
            String brand = carArray.getString("brand");
            String model = carArray.getString("model");
            String variant = carArray.getString("variant");
            double pricePM = carArray.getDouble("pricePM");
            double priceEM = carArray.getDouble("priceEM");
            double priceLabuan = carArray.getDouble("priceLabuan");
            double priceLangkawi = carArray.getDouble("priceLangkawi");
        }catch(IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void findViews(){
        listView = findViewById(R.id.listview);
    }


}
