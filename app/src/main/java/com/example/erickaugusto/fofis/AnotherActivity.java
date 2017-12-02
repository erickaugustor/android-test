package com.example.erickaugusto.fofis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Bundle extra = getIntent().getExtras();

        showMessage = findViewById(R.id.reciveText);

        //flag
        if(extra != null){
            String message = extra.getString("Message");
            int value = extra.getInt("Value");

            showMessage.setText(message + " " + String.valueOf(value));
        }

    }
}
