package com.dawikk.awesomecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdvancedCalculator extends AppCompatActivity {

    /* Event  buttons */
    public static Button BtnMC;
    public static Button BtnMR;
    public static Button BtnMplus;
    public static Button BtnMminus;
    public static Button BtnC;

    public static Button BtnPlusMinusBtn;

    public static Button BtnDivide;
    public static Button BtnMultiply;
    public static Button BtnMinus;
    public static Button BtnPlus;
    public static Button BtnDot;

    public static Button BtnEquals;

    /* Digit buttons */
    public static Button Btn0;
    public static Button Btn1;
    public static Button Btn2;
    public static Button Btn3;
    public static Button Btn4;
    public static Button Btn5;
    public static Button Btn6;
    public static Button Btn7;
    public static Button Btn8;
    public static Button Btn9;

    public static Button BtnSilnia;
    public static Button BtnKwadrat;
    public static Button BtnSqrt;
    public static Button BtnLn;

    /* EditText */
    public static EditText lcd;

    public static Integer containDot = 0;
    public static Integer addDot = 0;

    public static String savedNumber = "0";
    public static String number = "0";
    public static String memory = "0";

    public static Integer action = -1;

    public static Float memoryD = 0.0f;
    public static Float numberD = 0.0f;
    public static Float savedNumberD = 0.0f;

    @Override
    protected void onResume()
    {
        super.onResume();

        action = -1;
        containDot = 0;
        addDot = 0;

        savedNumber = "0";
        number = "";
        memory = "0";

        numberD = 0.0f;
        memoryD = 0.0f;
        savedNumberD = 0.0f;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);

        getSupportActionBar().hide();

        lcd = findViewById( R.id.editText );
        lcd.setText( "" );

        Btn0 = findViewById( R.id.button22 );
        Btn1 = findViewById( R.id.button18 );
        Btn2 = findViewById( R.id.button19 );
        Btn3 = findViewById( R.id.button20 );
        Btn4 = findViewById( R.id.button14 );
        Btn5 = findViewById( R.id.button15 );
        Btn6 = findViewById( R.id.button16 );
        Btn7 = findViewById( R.id.button10 );
        Btn8 = findViewById( R.id.button11 );
        Btn9 = findViewById( R.id.button12 );

        BtnMC = findViewById( R.id.button2 );
        BtnMR = findViewById( R.id.button5 );
        BtnMplus = findViewById( R.id.button3 );
        BtnMminus = findViewById( R.id.button4 );
        BtnC = findViewById( R.id.button6 );
        BtnPlusMinusBtn = findViewById( R.id.button7 );
        BtnDivide = findViewById( R.id.button8 );
        BtnMultiply = findViewById( R.id.button9 );
        BtnMinus = findViewById( R.id.button13 );
        BtnPlus = findViewById( R.id.button17 );
        BtnEquals = findViewById( R.id.button21 );
        BtnDot = findViewById( R.id.button23 );

        BtnSilnia = findViewById( R.id.button24 );
        BtnKwadrat = findViewById( R.id.button25 );
        BtnSqrt = findViewById( R.id.button26 );
        BtnLn = findViewById( R.id.button27 );

        BtnSilnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                silnia();
            }
        });
        BtnKwadrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kwadrat();
            }
        });
        BtnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqrt();
            }
        });
        BtnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ln();
            }
        });

        BtnPlusMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSign();
            }
        });

        BtnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearMemory();
            }
        });

        BtnMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoryRecall();
            }
        });

        BtnMplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToMemory();
            }
        });


        BtnMminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diffMemory();
            }
        });

        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 0 );
            }
        });
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 1 );
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 2 );
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 3 );
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 4 );
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 5 );
            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 6 );
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 7 );
            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 8 );
            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendToEditText( 9 );
            }
        });

        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAction( 1 );
            }
        });
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAction( 2 );
            }
        });
        BtnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAction( 3 );
            }
        });
        BtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAction( 4 );
            }
        });
        BtnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAction(-1);
            }
        });
        BtnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendDot();
            }
        });

    }

    public void silnia(){
        number = lcd.getText().toString();

        if( !number.equals("") ){
            int iloczyn = 1;
            for (int i=1; i <= Integer.parseInt( number ); i++) {
                iloczyn *= i;
            }

            number = Integer.toString( iloczyn );
            numberD = (float) Double.parseDouble( number );
            lcd.setText( numberD.toString() );
        }else{
            Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
        }
    }

    public void kwadrat(){
        number = lcd.getText().toString();
        numberD = Float.parseFloat( number ) * Float.parseFloat( number );

        lcd.setText( numberD.toString() );
    }

    public void sqrt(){
        if( !number.equals("") && Integer.parseInt( number ) > 0 ){
            number = lcd.getText().toString();
            numberD = (float) Math.sqrt( Float.parseFloat( number ) );

            lcd.setText( numberD.toString() );
        }else{
            Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
        }
    }

    public void ln(){
        if( !number.equals("") && Integer.parseInt( number ) > 0 ) {
            number = lcd.getText().toString();
            numberD = (float) Math.log(Float.parseFloat(number));

            lcd.setText(numberD.toString());
        }else{
            Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
        }
    }

    public void changeSign(){
        number = lcd.getText().toString();
        numberD = Float.parseFloat( number ) * -1;

        lcd.setText( numberD.toString() );
    }

    public void clearMemory(){
        memory = "0";
        memoryD = 0.0f;
        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void memoryRecall(){
        numberD = memoryD;
        number = memory;

        lcd.setText( number );
        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void addToMemory(){
        memoryD = memoryD + Float.parseFloat( lcd.getText().toString() );
        memory = Float.toString( memoryD );

        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void diffMemory(){
        memoryD = memoryD - Float.parseFloat( lcd.getText().toString() );
        memory = Float.toString( memoryD );

        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void clear(){
        action = -1;
        containDot = 0;
        addDot = 0;

        savedNumber = "0";
        number = "";

        numberD = 0.0f;
        savedNumberD = 0.0f;

        lcd.setText( number );
    }

    public void createNewAction( Integer action ){
        makeAction();

        this.action = action;
        lcd.setText( savedNumber );
    }

    public void makeAction(){
        switch( this.action ){
            case -1:
                savedNumberD = Float.parseFloat( lcd.getText().toString() );
                break;
            case 1: savedNumberD = numberD + savedNumberD;
                break;
            case 2: savedNumberD = savedNumberD - numberD;
                break;
            case 3: savedNumberD = savedNumberD * numberD;
                break;
            case 4: if( numberD != 0.0f && !number.equals("0") )
                savedNumberD = savedNumberD / numberD;
            else
                Toast.makeText(getApplicationContext(),"Nie dzielimy przez zero :o",Toast.LENGTH_SHORT).show();
                break;
            default: break;
        }

        savedNumber = Float.toString( savedNumberD );

        number = "";
        numberD = 0.0f;
        containDot = 0;

        lcd.setText( number );

        this.action = -1;
    }

    public void appendDot(){
        if( containDot == 0 ){
            if( number.equals("") )
                number = "0";

            number = number + ".";
        }else{
            Toast.makeText(getApplicationContext(),"Liczbę możemy podzielić na co najwyżej dwie części",Toast.LENGTH_SHORT).show();
        }

        lcd.setText( number );
        containDot = 1;
    }

    public void appendToEditText( int a ){
        number = number + Integer.toString(a);

        numberD = Float.parseFloat( number );

        lcd.setText( number );
    }
}
