package com.example.a201495_2.porkgestion.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;
import com.example.a201495_2.porkgestion.bo_clases.SpinData;

public class spinAdapter extends ArrayAdapter<SpinData> {

    private Context context;
    private SpinData[] values;

    public spinAdapter(Context context, int textViewResourceId,
                       SpinData[] values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public int getCount(){
        return values.length;
    }

    @Override
    public SpinData getItem(int position){
        return values[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(values[position].getValor());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setHeight(80);
        label.setText(values[position].getValor());
        return label;
    }
}
