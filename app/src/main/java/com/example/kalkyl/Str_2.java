package com.example.kalkyl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Str_2 extends AppCompatActivity implements View.OnClickListener {
    TextView firstNumber;
    TextView secondNumber;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button fri;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button pow;
    Button sqrt;
    Button sin;
    Button cos;
    Button clear;
    Button ravno;
    Button One_Windw;

    String act;
    boolean fnum;
    String chose;

    Spinner spinner;
    String[] str_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str2);

        Bundle arguments = getIntent().getExtras();
        str_array = arguments.getStringArray("key");
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Str_2.this, android.R.layout.simple_spinner_item, str_array);
        spinner.setAdapter(adapter);

        act = "";
        fnum = true;
        chose = "";



        firstNumber = findViewById(R.id.oneNomer);
        secondNumber = findViewById(R.id.secondNomer);
        result = findViewById(R.id.friNomer);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        fri = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        pow = findViewById(R.id.pow);
        sqrt = findViewById(R.id.sqrt);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        clear = findViewById(R.id.clear);
        ravno = findViewById(R.id.equals);
        One_Windw = findViewById(R.id.firstWindows);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        fri.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        pow.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        clear.setOnClickListener(this);
        ravno.setOnClickListener(this);
        One_Windw.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:

                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;

            case R.id.pow:
            case R.id.sqrt:
            case R.id.sin:
            case R.id.cos:
                Button button1 = (Button) view;
                chose = button1.getText().toString();
                if (act == button1.getText().toString()) {
                    act = button1.getText().toString();
                    if (!fnum) {
                        fnum = !fnum;
                    }
                } else {
                    fnum = !fnum;
                }
                break;

            case R.id.equals:
                float num1;
                if(firstNumber.getText().toString() == "") num1 = 0;
                else num1 = Float.valueOf(firstNumber.getText().toString());
                float num2;
                if(secondNumber.getText().toString() == "") num2 = 0;
                else num2 = Float.valueOf(secondNumber.getText().toString());
                String[] str_array1 = new String[10];
                switch (act) {
                    case ("^"):
                        double resPow = Math.pow(num1, num2);
                        result.setText(String.valueOf(resPow));
                        str_array1[0] = String.valueOf(num1 + "^" + num2 + " = " + resPow);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("√"):
                        double resSqrt = Math.pow(num1, (1/num2));
                        result.setText(String.valueOf(resSqrt));
                        str_array1[0] = String.valueOf(num2 + "√" + num1 + " = " + resSqrt);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("sin"):
                        double resSin = Math.sin(num1);
                        result.setText(String.valueOf(resSin));
                        str_array1[0] = String.valueOf("sin(" + num1 + ")" + " = " + resSin);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("cos"):
                        double resCos = Math.cos(num1);
                        result.setText(String.valueOf(resCos));
                        str_array1[0] = String.valueOf("cos(" + num1 + ")" + " = " + resCos);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                fnum = true;
                break;
            case R.id.secondWindows:
                break;
            case R.id.firstWindows:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}