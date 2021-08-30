package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edUser;
    private EditText edPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUser = (EditText) findViewById(R.id.edUser);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                onLogin();
                break;
            default:
                break;
        }
    }

    private void onLogin() {
        if(edUser.getText().toString().isEmpty() || edPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Chưa nhập username hoặc password", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USER_NAME", edUser.getText().toString());
            startActivity(intent);
        }
    }
}
