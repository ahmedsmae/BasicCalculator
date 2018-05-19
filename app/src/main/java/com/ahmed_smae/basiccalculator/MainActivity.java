package com.ahmed_smae.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    TextView
            tvInteractive,
            tvResult,
            tvC, tvBrackets, tvBack, tvDivide,
            tv7, tv8, tv9, tvMultiply,
            tv4, tv5, tv6, tvMinus,
            tv1, tv2, tv3, tvPlus,
            tv00, tv0, tvDot, tvEquals;
    private String interactiveText = "";
    private boolean isBracketsOn = false;
    private KeyPads mKeyPads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWidgetAndListeners();
        mKeyPads = new KeyPads(this);

        tvInteractive.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // calculate the string

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    private void setupWidgetAndListeners() {
        tvInteractive = findViewById(R.id.tvInteractive);
        tvResult = findViewById(R.id.tvResult);

        tvC = findViewById(R.id.tvC);
        tvC.setOnClickListener(this);
        tvBrackets = findViewById(R.id.tvBrackets);
        tvBrackets.setOnClickListener(this);
        tvBack = findViewById(R.id.tvBack);
        tvBack.setOnClickListener(this);

        tvDivide = findViewById(R.id.tvDivide);
        tvDivide.setOnClickListener(this);
        tvMultiply = findViewById(R.id.tvMultiply);
        tvMultiply.setOnClickListener(this);
        tvMinus = findViewById(R.id.tvMinus);
        tvMinus.setOnClickListener(this);
        tvPlus = findViewById(R.id.tvPlus);
        tvPlus.setOnClickListener(this);
        tvEquals = findViewById(R.id.tvEquals);
        tvEquals.setOnClickListener(this);


        tv0 = findViewById(R.id.tv0);
        tv0.setOnClickListener(this);
        tv00 = findViewById(R.id.tv00);
        tv00.setOnClickListener(this);
        tv1 = findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        tv2 = findViewById(R.id.tv2);
        tv2.setOnClickListener(this);
        tv3 = findViewById(R.id.tv3);
        tv3.setOnClickListener(this);
        tv4 = findViewById(R.id.tv4);
        tv4.setOnClickListener(this);
        tv5 = findViewById(R.id.tv5);
        tv5.setOnClickListener(this);
        tv6 = findViewById(R.id.tv6);
        tv6.setOnClickListener(this);
        tv7 = findViewById(R.id.tv7);
        tv7.setOnClickListener(this);
        tv8 = findViewById(R.id.tv8);
        tv8.setOnClickListener(this);
        tv9 = findViewById(R.id.tv9);
        tv9.setOnClickListener(this);
        tvDot = findViewById(R.id.tvDot);
        tvDot.setOnClickListener(this);
    }

    private void setText(String text) {
        if (mKeyPads.getNumbers().contains(text) && interactiveText.length() > 0 && interactiveText.substring(interactiveText.length() - 1).equals(getString(R.string.closeBracket))) {
            interactiveText += getString(R.string.multiply);
            interactiveText += text;
            tvInteractive.setText(interactiveText);
        } else if (mKeyPads.getOperators().contains(text) && interactiveText.length() > 0 && interactiveText.substring(interactiveText.length() - 1).equals(getString(R.string.openBracket))) {
            tvInteractive.setText(interactiveText);
        } else {
            interactiveText += text;
            tvInteractive.setText(interactiveText);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            /*
              Functions TextViews
              ------------------------------------------------------
             */
            case R.id.tvC:
                interactiveText = "";
                setText(interactiveText);
                isBracketsOn = false;
                break;
            case R.id.tvBrackets:
                if (interactiveText != null && interactiveText.length() > 0) {
                    if (isBracketsOn) {
                        if (mKeyPads.getOperators().contains(interactiveText.substring(interactiveText.length() - 1))) {
                            Toast.makeText(this, R.string.finish_equation_first, Toast.LENGTH_SHORT).show();
                        } else {
                            setText(getString(R.string.closeBracket));
                            isBracketsOn = false;
                        }
                    } else {
                        Log.d(TAG, "onClick: " + interactiveText.substring(interactiveText.length() - 1));
                        if (!mKeyPads.getOperators().contains(interactiveText.substring(interactiveText.length() - 1))) {

                            setText(getString(R.string.multiply) + getString(R.string.openBracket));
                        } else {
                            setText(getString(R.string.openBracket));
                        }
                        isBracketsOn = true;
                    }
                } else {
                    setText(getString(R.string.openBracket));
                    isBracketsOn = true;
                }
                break;
            case R.id.tvBack:
                if (interactiveText != null && interactiveText.length() > 0) {
                    if (interactiveText.substring(interactiveText.length() - 1).equals(getString(R.string.closeBracket))) {
                        isBracketsOn = true;
                    }
                    if (interactiveText.substring(interactiveText.length() - 1).equals(getString(R.string.openBracket))) {
                        isBracketsOn = false;
                    }

                    interactiveText = interactiveText.substring(0, interactiveText.length() - 1);
                    setText("");
                }
                break;

            /*
              Operators TextViews
              ------------------------------------------------------
             */
            case R.id.tvDivide:
                setText(getString(R.string.divide));
                break;
            case R.id.tvMultiply:
                setText(getString(R.string.multiply));
                break;
            case R.id.tvMinus:
                setText(getString(R.string.minus));
                break;
            case R.id.tvPlus:
                setText(getString(R.string.plus));
                break;
            case R.id.tvEquals:
                //setText(getString(R.string.equals));
                calculate();
                break;

            /*
              Numbers TextViews
              ------------------------------------------------------
             */
            case R.id.tv0:
                setText(getString(R.string._0));
                break;
            case R.id.tv00:
                setText(getString(R.string._00));
                break;
            case R.id.tv1:
                setText(getString(R.string._1));
                break;
            case R.id.tv2:
                setText(getString(R.string._2));
                break;
            case R.id.tv3:
                setText(getString(R.string._3));
                break;
            case R.id.tv4:
                setText(getString(R.string._4));
                break;
            case R.id.tv5:
                setText(getString(R.string._5));
                break;
            case R.id.tv6:
                setText(getString(R.string._6));
                break;
            case R.id.tv7:
                setText(getString(R.string._7));
                break;
            case R.id.tv8:
                setText(getString(R.string._8));
                break;
            case R.id.tv9:
                setText(getString(R.string._9));
                break;
            case R.id.tvDot:
                if (!interactiveText.contains(getString(R.string.dot))) {
                    setText(getString(R.string.dot));
                }
                break;
            default:

        }
    }

    private void calculate() {
//        Double result = 0d;
        interactiveText = interactiveText
                .replace("(", " ")
                .replace(")", " ")
                .replace(getString(R.string.plus), "+")
                .replace(getString(R.string.minus), "-")
                .replace(getString(R.string.divide), "/")
                .replace(getString(R.string.multiply), "*");

//        String[] parts = interactiveText.split(" ");
//        for (String part : parts){
//            Double partResult = Double.parseDouble(part);
//            result += partResult;
//        }

        tvResult.setText("");
        tvInteractive.setText("");
    }
}
