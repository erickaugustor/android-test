package com.example.erickaugusto.fofis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ButtonAnotherActivity;
    private final int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "OnCreate Called", Toast.LENGTH_SHORT).show();

        ButtonAnotherActivity = findViewById(R.id.buttonAnotherActivity);
        ButtonAnotherActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w){
               //Intent é uma ação, o que o aplicativo deverá fazer

                /* Você pode fazer isso:
                startActivity(new Intent(MainActivity.this, AnotherActivity.class));

                Ou isso: */

                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("Message", "Hello from another activity");
                intent.putExtra("Value", 123);

                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("returnData");

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        }
    }




    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "OnStart Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(MainActivity.this, "OnPostResume Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "OnStop Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "OnDestroy Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "OnPause Called", Toast.LENGTH_SHORT).show();
    }
}
