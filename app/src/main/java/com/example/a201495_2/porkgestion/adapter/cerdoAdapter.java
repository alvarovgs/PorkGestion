package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.Cerdo;

import java.util.ArrayList;

public class cerdoAdapter extends BaseAdapter {
    private Context appContext;
    private ArrayList<Cerdo> listCerdo;
    public cerdoAdapter(Context appContext, ArrayList<Cerdo> listCerdo) {
        this.appContext = appContext;
        this.listCerdo = listCerdo;
    }

    @Override
    public int getCount() {
        return listCerdo.size();
    }

    @Override
    public Object getItem(int position) {
        return listCerdo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<Cerdo> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listCerdo.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_cerdo, parent, false);
        }
        TextView tv_Codigo= (TextView) rowView.findViewById(R.id.codigo);
        TextView tv_Fechanace= (TextView) rowView.findViewById(R.id.fechanace);
        TextView tv_PesoNace= (TextView) rowView.findViewById(R.id.pesonace);
        TextView tv_Raza= (TextView) rowView.findViewById(R.id.raza);

        Cerdo objCerdo = this.listCerdo.get(position);
        tv_Codigo.setText(objCerdo.getStrCodigo());
        tv_Fechanace.setText(objCerdo.getStrFechaNace());
        tv_PesoNace.setText(String.valueOf(objCerdo.getlPesoNace()));
        tv_Raza.setText(objCerdo.getStrRaza());
        return rowView;
    }
}
