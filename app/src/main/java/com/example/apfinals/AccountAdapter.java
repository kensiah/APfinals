package com.example.apfinals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AccountAdapter extends ArrayAdapter {
    private ArrayList<Account> data;
    private Context context;
    private View v;

    public AccountAdapter(Context context, ArrayList<Account> data){
        super(context,R.layout.activity_login);
        this.data = data;
        this.context = context;
    }

    @Nullable
    @Override

    public Object getItem(int pos){
        return super.getItem(pos);
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
        View v;
        Viewholder holder;
        if(convertView == null){
            holder = new Viewholder();
            v = LayoutInflater.from(context).inflate(R.layout.activity_login,null);

            holder.editUsername = v.findViewById(R.id.edit_username);
            holder.editPassword = v.findViewById(R.id.edit_password);

            v.setTag(holder);

        }else{
            holder = (Viewholder) convertView.getTag();
            v = convertView;
        }

        Account model = (Account)getItem(position);

        holder.editUsername.setText(model.getUsername());
        holder.editPassword.setText(model.getPassword());

        return v;
    }

    class Viewholder{
        EditText editUsername,editPassword;
    }
}
