package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Long number1 = 0L;
    private static Long number2 = 0L;
    private static String operator;
    private static boolean side2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberClick(View view) {
        TextView btn = (TextView) findViewById(view.getId());
        Long num = Long.parseLong(btn.getText().toString());
        if(!side2){
            number1 = number1 * 10 + num;
            TextView textView = (TextView) findViewById(R.id.screen);
            String num1 = number1.toString();
            textView.setText(num1);
        }else {
            number2 = number2 * 10 + num;
            TextView textView = (TextView) findViewById(R.id.screen);
            String num2 = number2.toString();
            textView.setText(num2);
        }
    }

    public void clearAll(View view) {
        number1 = 0L;
        number2 = 0L;
        operator = null;
        side2 = false;
        TextView textView = (TextView) findViewById(R.id.screen);
        textView.setText("");
    }

    public void operatorClick(View view) {
        TextView btn = (TextView) findViewById(view.getId());
        operator = btn.getText().toString();
        btn.setBackgroundColor(getResources().getColor(R.color.white));
        btn.setTextColor(getResources().getColor(R.color.black));
        side2 = true;
    }

    public void resultClick(View view) {
        float result = 0F;
        if(operator.equals("+")){
            result =  (float) number1+ number2;
        } else if(operator.equals("-")){
            result = (float) number1 - number2;
        } else if(operator.equals("X")){
            result = (float) number1 * number2;
        } else if(operator.equals("/")){
            result = (float) number1 / number2;
        }
        TextView textView = (TextView) findViewById(R.id.screen);
        String res = String.valueOf(result);
        if(res.endsWith(".0")){
            res = res.subSequence(0, res.length() - 2).toString();
        }
        textView.setText(res);

    }
}