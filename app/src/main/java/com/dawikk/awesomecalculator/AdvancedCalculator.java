package com.dawikk.awesomecalculator;

import android.content.Intent;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;

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

    public static Button BtnSin;
    public static Button BtnCos;
    public static Button BtnTan;
    public static Button BtnLog;

    /* EditText */
    public static EditText lcd;

    public static Integer containDot = 0;
    public static Integer addDot = 0;

    public static Integer action = -1;
    public static Integer previousAction = -3;
    public static Integer changed = 0;

    public static String number = "0";
    public static String memory = "0";

    public static BigDecimal memoryD = new BigDecimal("0");
    public static BigDecimal numberD = new BigDecimal("0");
    public static BigDecimal savedNumberD = new BigDecimal("0");

    @Override
    protected void onResume()
    {
        super.onResume();

        action = -1;
        previousAction = -3;
        containDot = 0;
        addDot = 0;

        numberD = new BigDecimal("0");
        memoryD = new BigDecimal("0");
        savedNumberD = new BigDecimal("0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);

        getSupportActionBar().hide();

        lcd = findViewById( R.id.editText );
        lcd.setText( "0" );

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

        BtnSin = findViewById( R.id.button28 );
        BtnCos = findViewById( R.id.button29 );
        BtnTan = findViewById( R.id.button30 );
        BtnLog = findViewById( R.id.button31 );


        BtnSilnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 5 );
            }
        });
        BtnKwadrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 6 );
            }
        });
        BtnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 7 );
            }
        });
        BtnLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 8 );
            }
        });

        BtnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 9 );
            }
        });
        BtnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 10 );
            }
        });
        BtnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 11 );
            }
        });
        BtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 12 );
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
                createAction( 1 );
            }
        });
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 2 );
            }
        });
        BtnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 3 );
            }
        });
        BtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction( 4 );
            }
        });
        BtnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAction(-1);
            }
        });
        BtnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendDot();
            }
        });

    }

    public void createAction( int acti ){
        if( acti == -1 ){
            if( previousAction != -3 ){
                if( changed == 1 )
                    makeAction( previousAction );
                previousAction = -3;
            }
        }else if( acti == 5 || acti == 6 || acti == 7 || acti == 8 || acti == 9 || acti == 10 || acti == 11 || acti == 12 ){
            if( previousAction != -3 ){
                makeAction( previousAction );
            }
            previousAction = -3;
            number = lcd.getText().toString();
            makeAction( acti );
        }else{
            if( changed == 1 || number.equals( "0" )) {
                if (previousAction != -3){
                    makeAction(previousAction);
                     previousAction = acti;
                 }else{
                    previousAction = acti;
                    if( changed == 1 )
                        savedNumberD = numberD;
                }
            }else{
                previousAction = acti;
            }
        }

        number = "0";
        numberD = new BigDecimal("0");
        containDot = 0;
        changed = 0;

        lcd.setText( savedNumberD.toPlainString() );

    }

    public void makeAction( int _action ){
        switch( _action ){
            case 1: plus( );
                break;
            case 2: minus();
                break;
            case 3: multipy();
                break;
            case 4: divide();
                break;
            case 5:
                    silnia();
                break;
            case 6: kwadrat();
                break;
            case 7:
                    sqrt();
                break;
            case 8: ln();
                break;
            case 9: sin();
                break;
            case 10: cos();
                break;
            case 11: tan();
                break;
            case 12: log();
            default: break;
        }

        number = "0";
        numberD = new BigDecimal("0");
        containDot = 0;
        changed = 0;
    }

    public void plus( ){
        savedNumberD = savedNumberD.add( numberD );
    }

    public void minus(){
        savedNumberD = savedNumberD.subtract( numberD );
    }

    public void multipy(){
        savedNumberD = savedNumberD.multiply( numberD );
    }

    public void divide(){
        if( numberD.compareTo( BigDecimal.ZERO ) != 0 && changed == 1 )
            savedNumberD = savedNumberD.divide( numberD, MathContext.DECIMAL32 );
        else
            Toast.makeText(getApplicationContext(), "Podano zły parametr", Toast.LENGTH_LONG).show();
    }

    public void silnia(){
        if( changed == 1 )
            if( isIntegerValue(numberD) ){
                int iloczyn = 1;
                for (int i=1; i <= numberD.intValue(); i++) {
                    iloczyn *= i;
                }

                savedNumberD = new BigDecimal(Integer.toString(iloczyn));
            }else{
                Toast.makeText(getApplicationContext(), "Podano zły parametr", Toast.LENGTH_LONG).show();
            }
        else
            if( isIntegerValue(savedNumberD) ){
                int iloczyn = 1;
                for (int i=1; i <= savedNumberD.intValue(); i++) {
                    iloczyn *= i;
                }

                savedNumberD = new BigDecimal(Integer.toString(iloczyn));
            }else{
                Toast.makeText(getApplicationContext(), "Podano zły parametr", Toast.LENGTH_LONG).show();
            }


    }

    public void sin(){
        if( changed == 1 )
            savedNumberD = new BigDecimal( Math.sin( Double.parseDouble( number ) ) );
        else
            savedNumberD = new BigDecimal( Math.sin( savedNumberD.doubleValue() ) );
    }

    public void cos(){
        if( changed == 1 )
            savedNumberD = new BigDecimal( Math.cos( Double.parseDouble( number ) ) );
        else
            savedNumberD = new BigDecimal( Math.cos( savedNumberD.doubleValue() ) );
    }

    public void tan(){
        if( changed == 1 )
            savedNumberD = new BigDecimal( Math.tan( Double.parseDouble( number ) ) );
        else
            savedNumberD = new BigDecimal( Math.tan( savedNumberD.doubleValue() ) );
    }

    public void log(){
        if( changed == 1 ) {
            if( numberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.log10(  Double.parseDouble( number )  ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }else {
            if( savedNumberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.log10(  savedNumberD.doubleValue() ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void kwadrat(){
        if( changed == 1 )
            savedNumberD = numberD.pow(2);
        else
            savedNumberD = savedNumberD.pow(2);
    }

    public void sqrt(){
        if( changed == 1 ) {
            if( numberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.sqrt(  Double.parseDouble( number )  ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }else {
            if( savedNumberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.sqrt(  savedNumberD.doubleValue() ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void ln(){
        if( changed == 1 ) {
            if( numberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.log(  Double.parseDouble( number )  ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }else {
            if( savedNumberD.doubleValue() > 0 ){
                savedNumberD = new BigDecimal( Math.log(  savedNumberD.doubleValue() ) );
            }else{
                Toast.makeText(getApplicationContext(),"Zly parametr",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void changeSign(){
        numberD = numberD.negate();
        lcd.setText( numberD.toString() );
    }

    public void clearMemory(){
        memory = "0";
        memoryD = new BigDecimal( "0" );
        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void memoryRecall(){
        numberD = memoryD;
        number = memory;

        lcd.setText( number );
        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void addToMemory(){
        memoryD = memoryD.add( numberD );;
        memory = memoryD.toString();

        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void diffMemory(){
        memoryD = memoryD.subtract( numberD );;
        memory = memoryD.toString();

        Toast.makeText(getApplicationContext(),"M: " + memory,Toast.LENGTH_SHORT).show();
    }

    public void clear(){
        action = -1;
        containDot = 0;
        addDot = 0;
        changed = 0;
        previousAction = -3;

        number = "0";

        savedNumberD = new BigDecimal( "0" );
        numberD = new BigDecimal("0");

        lcd.setText( number );
    }

/*  public void createNewAction( Integer action ){

        if( !number.equals("") ) {
        makeAction();

        this.action = action;
        lcd.setText( savedNumber );}
    }*/

    public void appendDot(){
        if( containDot == 0 ){
            if( number.equals("") )
                number = "0";

            number = number + ".";
            containDot = 1;
        }else{
            Toast.makeText(getApplicationContext(),"Liczbę możemy podzielić na co najwyżej dwie części",Toast.LENGTH_SHORT).show();
        }

        lcd.setText( number );
    }

    public void appendToEditText( int a ){
        if( number.equals("0") ){
            number = Integer.toString(a);
        }else{
            number = number + Integer.toString(a);
        }

        changed = 1;
        numberD = new BigDecimal( number );

        lcd.setText( number );
    }

    private boolean isIntegerValue(BigDecimal bd) {
        return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
    }
}
