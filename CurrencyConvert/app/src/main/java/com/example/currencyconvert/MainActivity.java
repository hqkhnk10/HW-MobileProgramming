package com.example.currencyconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText from,to;
    public void convertToEuro(View view){
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);

        int dollars = Integer.parseInt(from.getText().toString());
        int vnd = 22000;

        double result = dollars * vnd ;
        to.setText(""+result);
    }
    public void clear(View view){
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        from.setText("");
        to.setText("");
    }
    public void convertMoney(){
        EditText from = (EditText) findViewById(R.id.from);
        EditText to = (EditText) findViewById(R.id.to);
        int dollars = Integer.parseInt(from.getText().toString());
        int vnd = 22000;
        double result = dollars * vnd ;
        to.setText(""+result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        from.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                convertMoney();
            }
        });
    }
}