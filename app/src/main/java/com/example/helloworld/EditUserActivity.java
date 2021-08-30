package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDone;
    private EditText edUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        edUser = (EditText) findViewById(R.id.edUser);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");
        edUser.setText(username);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                onDone();
                break;
            default:
                break;
        }
    }

    private void onDone() {
        if(edUser.getText().toString().isEmpty()){
            Toast.makeText(this, "Chưa nhập username", Toast.LENGTH_SHORT).show();
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("RESULT", edUser.getText().toString());
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }
}
