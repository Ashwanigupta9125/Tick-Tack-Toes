package com.example.tick_tack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class slaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slaps);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        Button but1=(Button)findViewById(R.id.Button1);
        Button but2=(Button)findViewById(R.id.Button);
        Button but3=(Button)findViewById(R.id.Button2);

        but1.setOnClickListener(v->{

            Toast.makeText(getApplicationContext(), "COUNTDOWN TIMER SET TO 1 MINUTE",Toast.LENGTH_LONG).show();
            Intent i1=new Intent(this,MainActivity.class);
            String x1="60000";
            i1.putExtra("key1", x1);
            startActivity(i1);

        });

        but2.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(), "COUNTDOWN TIMER SET TO 1.5 MINUTE", Toast.LENGTH_LONG).show();
            Intent i1=new Intent(this,MainActivity.class);
            String x1="90000";
            i1.putExtra("key1", x1);
            startActivity(i1);
        });

    but3.setOnClickListener(v->{
        Toast.makeText(getApplicationContext(), "COUNTDOWN TIMER SET TO 2 MINUTE", Toast.LENGTH_LONG).show();
        Intent i1=new Intent(this,MainActivity.class);
        String x1="120000";
        i1.putExtra("key1", x1);
        startActivity(i1);

    });

    }


}