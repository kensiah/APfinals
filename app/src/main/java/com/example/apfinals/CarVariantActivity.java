package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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


public class CarVariantActivity extends AppCompatActivity {
    private TextView tvModel;
    private ImageView imageView;
    private ListView listView;
    private ArrayList<Car> data = new ArrayList<>();
    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_variants);
        getDataFromAPI();
    }

    private void findViews(){
        tvModel = findViewById(R.id.tv_model);
        imageView = findViewById(R.id.img_model);
        listView = findViewById(R.id.list_item);
        CarAdapter adapter = new CarAdapter(this,data);
        listView.setAdapter(adapter);
    }

    private void setListeners(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car selectedItem = (Car) listView.getAdapter().getItem(position);
                String model = selectedItem.getModel();
                String variant = selectedItem.getVariant();
                Intent i = new Intent(CarVariantActivity.this, CarPriceActivity.class);
                i.putExtra("model",model);
                i.putExtra("variant",variant);
                startActivity(i);
            }
        });
    }

    private void initialize(){
        Bundle bundle = getIntent().getExtras();

        String model = bundle.getString("model");
        tvModel.setText(model);

        switch(model.toUpperCase()){
            case "X70":
                imageView.setImageDrawable(getDrawable(R.drawable.x70));
                break;

            case "SAGA":
                imageView.setImageDrawable(getDrawable(R.drawable.saga));
                break;

            case "PERSONA":
                imageView.setImageDrawable(getDrawable(R.drawable.persona));
                break;

            case "PERDANA":
                imageView.setImageDrawable(getDrawable(R.drawable.perdana));
                break;

            case "EXORA":
                imageView.setImageDrawable(getDrawable(R.drawable.exora));
                break;

            case "IRIZ":
                imageView.setImageDrawable(getDrawable(R.drawable.iriz));
                break;

            case "PREVE":
                imageView.setImageDrawable(getDrawable(R.drawable.preve));
                break;
        }
        findViews();
        setListeners();
    }

    private void getDataFromAPI(){
        Request request = new Request.Builder().url("https://api.myjson.com/bins/1c6q6s").build();

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
                        String variantName = singleObject.getString("variant");
                        model.setBrand(singleObject.getString("brand"));
                        model.setModel(modelName);
                        model.setVariant(variantName);
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
