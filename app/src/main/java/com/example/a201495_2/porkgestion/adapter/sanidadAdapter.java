package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.Sanidad;
import java.util.ArrayList;

public class sanidadAdapter extends BaseAdapter {
    private Context appContext;
    private ArrayList<Sanidad> listSanidad;
    public sanidadAdapter(Context appContext, ArrayList<Sanidad> listSanidad) {
        this.appContext = appContext;
        this.listSanidad = listSanidad;
    }

    @Override
    public int getCount() {
        return listSanidad.size();
    }

    @Override
    public Object getItem(int position) {
        return listSanidad.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<Sanidad> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listSanidad.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_sanidad, parent, false);
        }
        TextView lblNombreMed = rowView.findViewById(R.id.lblNombreMed);
        TextView lblTipoMed = rowView.findViewById(R.id.lblTipoMed);
        TextView lblDescripcionc = rowView.findViewById(R.id.lblDescripcion);
        Sanidad objBoClass = this.listSanidad.get(position);
        lblNombreMed.setText(objBoClass.getStrNombreMedicamento());
        lblTipoMed.setText(objBoClass.getStrTipoMedicamento());
        lblDescripcionc.setText(objBoClass.getStrObservaciones());
        return rowView;
    }
}
