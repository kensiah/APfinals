package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class CarDetailActivity extends AppCompatActivity {
    private TextView tvModel,tvVariant,tvPricePm,tvPriceEM,tvPriceLabuan,tvPriceLangkawi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        findViews();
        initialData();
    }

    private void findViews(){
        tvModel = findViewById(R.id.tv_model);
        tvVariant = findViewById(R.id.tv_variant);
        tvPricePm = findViewById(R.id.tv_pricePM);
        tvPriceEM = findViewById(R.id.tv_priceEM);
        tvPriceLabuan = findViewById(R.id.tv_priceLabuan);
        tvPriceLangkawi = findViewById(R.id.tv_priceLangkawi);
    }

    private void initialData(){
        Bundle bundle = getIntent().getExtras();

        tvModel.setText(bundle.getString("model"));
        tvVariant.setText(bundle.getString("variant"));
        tvPricePm.setText(bundle.getString("pricePM"));
        tvPriceEM.setText(bundle.getString("priceEM"));
        tvPriceLabuan.setText(bundle.getString("priceLabuan"));
        tvPriceLangkawi.setText(bundle.getString("priceLangkawi"));
    }
}
