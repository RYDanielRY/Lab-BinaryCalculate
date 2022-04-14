package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class TranslateActivityJava extends AppCompatActivity
{
    TextView binaryNumber;
    EditText editNumber;
    RadioButton radioR8;
    RadioButton radioR10;
    RadioButton radioR16;
    TextView textRes;
    Button translate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_java);

        binaryNumber = findViewById(R.id.binaryNumber);
        editNumber = findViewById(R.id.editTextNumber);
        radioR8 = findViewById(R.id.type1);
        radioR10 = findViewById(R.id.type2);
        radioR16 = findViewById(R.id.type3);
        textRes = findViewById(R.id.TextRes);
        translate = findViewById(R.id.translateButton);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioR8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int num = Integer.parseInt(editNumber.getText().toString());
                        num = toTen(num);
                        int eightNum = 0;
                        int j = 0;
                        while (num > 7) {
                            eightNum += (num % 8) * Math.pow(10, j);
                            num /= 8;
                            j++;
                        }
                        eightNum += (num % 8) * Math.pow(10, j);
                        textRes.setText(Integer.toString(eightNum));
                    }
                });
                radioR10.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        int num = Integer.parseInt(editNumber.getText().toString());
                        num = toTen(num);
                        textRes.setText(Integer.toString(num));
                    }
                });
                radioR16.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        int num = Integer.parseInt(editNumber.getText().toString());
                        num = toTen(num);
                        ArrayList<String> sixtenNum = new ArrayList<String>();
                        while (num > 15) {
                            sixtenNum.add(swST(num));
                            num /= 16;
                        }
                        sixtenNum.add(swST(num));

                        String str = "";
                        for (int i = sixtenNum.size()-1; i>=0; i--){
                            str += sixtenNum.get(i);
                        }
                        textRes.setText(str);
                    }
                });
            }
        });
    }

    public static int toTen(int num) {
        int tenNum = 0;
        int j = 0;
        while (num > 1) {
            tenNum += (num % 10) * Math.pow(2, j);
            num /= 10;
            j++;
        }
        tenNum += num * Math.pow(2, j);
        return tenNum;
    }

    public static String swST (int num){
        int digit = num % 16;
        switch (digit) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return (Integer.toString(digit));
        }
    }

}