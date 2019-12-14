package com.example.apfinals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter {
    private ArrayList<Car> data;
    private Context context;

    public CarAdapter(Context context, ArrayList<Car> data){
        super(context,R.layout.single_car_list_item);
        this.data = data;
        this.context = context;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            v = LayoutInflater.from(context).inflate(R.layout.single_car_list_item,null);

            holder.tvModel = v.findViewById(R.id.tv_model);
            holder.imageModel = v.findViewById(R.id.img_model);

            v.setTag(holder);

        } else{
            holder = (ViewHolder) convertView.getTag();
            v = convertView;
        }

        Car model = (Car) getItem(position);

        holder.tvModel.setText(model.getModel());
        holder.imageModel.setImageDrawable(model.getPicture());

        return v;
    }

    class ViewHolder{
        TextView tvModel;
        ImageView imageModel;
    }
}
