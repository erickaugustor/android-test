package com.example.erickaugusto.fofis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Bundle extra = getIntent().getExtras();

        showMessage = findViewById(R.id.reciveText);

        backButton = findViewById(R.id.backButton);

        //flag
        if(extra != null){
            String message = extra.getString("Message");
            int value = extra.getInt("Value");

            showMessage.setText(message + " " + String.valueOf(value));
        }

        backButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
               Intent returnIntent = getIntent();
               returnIntent.putExtra("returnData", "From second activity");

               setResult(RESULT_OK, returnIntent);
               finish();
            }
        });

    }

}
