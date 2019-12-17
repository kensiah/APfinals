package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
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

    }
}
