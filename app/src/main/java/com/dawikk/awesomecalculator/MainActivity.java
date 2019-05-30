package com.dawikk.awesomecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Button turnOnCalc;
    public static Button turnOnCalc2;
    public static Button turnOnCalc3;
    public static Button turnOnCalc4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        turnOnCalc = findViewById( R.id.button );

        turnOnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Calculator.class));
            }
        });

        turnOnCalc2 = findViewById( R.id.butto2 );

        turnOnCalc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdvancedCalculator.class));
            }
        });

        turnOnCalc3 = findViewById( R.id.butto3 );

        turnOnCalc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( getBaseContext(), "Dawid Wrzesiński, 209515", Toast.LENGTH_LONG).show();
            }
        });

        turnOnCalc4 = findViewById( R.id.butto4 );

        turnOnCalc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
