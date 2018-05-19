package com.ahmed_smae.basiccalculator;

import android.content.Context;
import java.util.ArrayList;

/**
 * Created by Ahmed Afifi on 5/17/2018.
 */
public class KeyPads {

    private Context mContext;

    KeyPads(Context context) {
        this.mContext = context;
    }

    public ArrayList getOperators(){
        ArrayList<String> operators = new ArrayList<>();
        operators.add(mContext.getString(R.string.divide));
        operators.add(mContext.getString(R.string.multiply));
        operators.add(mContext.getString(R.string.minus));
        operators.add(mContext.getString(R.string.plus));
        return operators;
    }

    public ArrayList getNumbers(){
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add(mContext.getString(R.string._0));
        numbers.add(mContext.getString(R.string._00));
        numbers.add(mContext.getString(R.string._1));
        numbers.add(mContext.getString(R.string._2));
        numbers.add(mContext.getString(R.string._3));
        numbers.add(mContext.getString(R.string._4));
        numbers.add(mContext.getString(R.string._5));
        numbers.add(mContext.getString(R.string._6));
        numbers.add(mContext.getString(R.string._7));
        numbers.add(mContext.getString(R.string._8));
        numbers.add(mContext.getString(R.string._9));
        numbers.add(mContext.getString(R.string.dot));
        return numbers;
    }




}
