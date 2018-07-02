package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.reproduccion;

import java.util.ArrayList;

public class reproduccionAdapter extends BaseAdapter{
    private Context appContext;
    private ArrayList<reproduccion> listGestantes;
    public reproduccionAdapter(Context appContext, ArrayList<reproduccion> listGestantes) {
        this.appContext = appContext;
        this.listGestantes = listGestantes;
    }

    @Override
    public int getCount() {
        return listGestantes.size();
    }

    @Override
    public Object getItem(int position) {
        return listGestantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<reproduccion> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listGestantes.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_gestantes, parent, false);
        }
        TextView idHembra = rowView.findViewById(R.id.lblIDCerda);
        TextView strFechaMonta = rowView.findViewById(R.id.lblFechaMonta);
        TextView idVerraco = rowView.findViewById(R.id.lblVerraco);
        TextView strTipoMonta = rowView.findViewById(R.id.lblTipoMonta);
        TextView strEstado = rowView.findViewById(R.id.lblEstado);
        reproduccion objBoClass = this.listGestantes.get(position);
        idHembra.setText(objBoClass.getStrCodigoHembra());
        strFechaMonta.setText(objBoClass.getStrFechaMonta());
        idVerraco.setText(objBoClass.getStrCodigoVerraco());
        strTipoMonta.setText(objBoClass.getStrTipoMonta());
        strEstado.setText(objBoClass.getstrEstado());
        return rowView;
    }
}
