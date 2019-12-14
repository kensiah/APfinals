package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class CarVariantActivity extends AppCompatActivity {
    private TextView tvModel;
    private ImageView imageView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_variants);
        findViews();
        initialData();
    }

    private void findViews(){
        tvModel = findViewById(R.id.tv_model);
        imageView = findViewById(R.id.img_model);
        listView = findViewById(R.id.list_item);
    }

    private void initialData(){
        Bundle bundle = getIntent().getExtras();

        String model = bundle.getString("model");
        tvModel.setText(model);

        switch(model.toUpperCase()){
            case "X70":
                imageView.setImageDrawable(getDrawable(R.drawable.x70));
                break;
        }

    }
}
