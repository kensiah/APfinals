package com.example.apfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private String username,password;
    private EditText editUsername,editPassword;
    private Button btnLogin;
    private AccountDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        setListeners();
        setUpDatabase();
    }

    private void findViews(){
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void setListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = "kensiah";
                password = "kensiah123";
                String inputUsername = editUsername.getText().toString();
                String inputPassword = editPassword.getText().toString();
                if(inputUsername.equals(username) && inputPassword.equals(password)){
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this,"Invalid Login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setUpDatabase(){
        dbHelper = new AccountDBHelper(this);
    }

    private void setUpAdapter(){
        ArrayList<Account> accountList = new ArrayList<>();
        accountList = dbHelper.getAllAccounts();


    }

}
