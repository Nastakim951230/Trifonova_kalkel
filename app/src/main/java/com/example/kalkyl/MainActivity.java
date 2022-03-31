package com.example.kalkyl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    Button plus;
    Button minus;
    Button ymnogit;
    Button delenie;
    Button clear;
    Button ravno;
    Button Sekond_Wind;

    String act;
    boolean fnum;
    String chose;

    Spinner spinner;
    String[] str_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle arguments = getIntent().getExtras();
        str_array = arguments.getStringArray("key");
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, str_array);
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
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        ymnogit = findViewById(R.id.multiply);
        delenie = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        ravno = findViewById(R.id.equals);
        Sekond_Wind = findViewById(R.id.secondWindows);


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
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        ymnogit.setOnClickListener(this);
        delenie.setOnClickListener(this);
        clear.setOnClickListener(this);
        ravno.setOnClickListener(this);
        Sekond_Wind.setOnClickListener(this);

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

            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
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
                float num1 = Float.valueOf(firstNumber.getText().toString());
                float num2 = Float.valueOf(secondNumber.getText().toString());
                String[] str_array1 = new String[10];
                switch (act) {
                    case ("+"):
                        float resPlus = num1 + num2;
                        result.setText(String.valueOf(resPlus));
                        str_array1[0] = String.valueOf(num1 + " + " + num2 + " = " + resPlus);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("-"):
                        float resMinus = num1 - num2;
                        result.setText(String.valueOf(resMinus));
                        str_array1[0] = String.valueOf(num1 + " - " + num2 + " = " + resMinus);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("x"):
                        float resMultiply = num1 * num2;
                        result.setText(String.valueOf(resMultiply));
                        str_array1[0] = String.valueOf(num1 + " * " + num2 + " = " + resMultiply);
                        for(int i=0; i<9;i++){
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++){
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("/"):
                        float resDivide = num1 / num2;
                        result.setText(String.valueOf(resDivide));
                        str_array1[0] = String.valueOf(num1 + " / " + num2 + " = " + resDivide);
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
                Intent intent=new Intent(this,Str_2.class);
                startActivity(intent);
                break;
            case R.id.firstWindows:
                break;




        }
    }
}

