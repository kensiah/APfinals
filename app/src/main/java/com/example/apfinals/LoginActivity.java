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
    private Button btnLogin,btnRegister;
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
        btnRegister = findViewById(R.id.btn_register);
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

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editUsername.getText().toString().isEmpty() &&
                !editPassword.getText().toString().isEmpty()){
                    AccountDBHelper dbHelper = new AccountDBHelper(LoginActivity.this);
                    Account account = new Account();
                    account.setUsername(editUsername.getText().toString());
                    account.setPassword(editPassword.getText().toString());
                    dbHelper.insertAccount(account);
                }else{
                    if(editUsername.getText().toString().isEmpty()){
                        editUsername.setError("Cannot be empty");
                    }

                    if(editPassword.getText().toString().isEmpty()){
                        editPassword.setError("Cannot be empty");
                    }
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
