package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView2);
        display.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }


                return true;
            }

        });
        display.setShowSoftInputOnFocus(false);
    }

    private void updateTEXt(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
        }

        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%S", leftStr,strToAdd, rightStr));
        display.setSelection(cursorPos + 1);
    }

    public  void zero (View view  ) {
        updateTEXt("0");

    }
    public  void one (View view  ) {
        updateTEXt("1");

    }
    public  void two (View view  ) {
        updateTEXt("2");

    }
    public  void three (View view  ) {
        updateTEXt("3");

    }
    public  void four (View view  ) {
        updateTEXt("4");

    }
    public  void five (View view  ) {
        updateTEXt("5");

    }
    public  void six (View view  ) {
        updateTEXt("6");

    }
    public  void seven (View view  ) {
        updateTEXt("7");

    }
    public  void eight (View view  ) {
        updateTEXt("8");

    }
    public  void nine (View view  ) {
        updateTEXt("9");

    }
    public  void clear (View view  ) {
        display.setText("");

    }
    public  void exponent (View view  ) {
        updateTEXt("^");

    }
    public  void divide (View view  ) {
        updateTEXt("÷");

    }
    public  void multiply (View view  ) {
        updateTEXt("x");

    }
    public  void add (View view  ) {
        updateTEXt("+");

    }
    public  void karl (View view  ) {


    }
    public  void subtract (View view  ) {
        updateTEXt("-");

    }
    public  void plusMinus (View view  ) {
        updateTEXt("+/-");

    }
    public  void point (View view  ) {
        updateTEXt(".");

    }
    public  void equals (View view  ) {
        String userExp = display.getText().toString();
        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public  void backspace (View view  ) {
        int cursorPos = display.getSelectionStart();
        int texLen =display.getText().length();
        if (cursorPos != 0 && texLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }


    }


}