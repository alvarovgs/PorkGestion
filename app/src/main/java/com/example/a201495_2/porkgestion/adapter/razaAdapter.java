package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.Raza;
import java.util.ArrayList;

public class razaAdapter extends BaseAdapter {
    private Context appContext;
    private ArrayList<Raza> listRaza;
    public razaAdapter(Context appContext, ArrayList<Raza> listRaza) {
        this.appContext = appContext;
        this.listRaza = listRaza;
    }

    @Override
    public int getCount() {
        return listRaza.size();
    }

    @Override
    public Object getItem(int position) {
        return listRaza.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<Raza> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listRaza.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_raza, parent, false);
        }
        TextView lblNombreRaza = rowView.findViewById(R.id.lblNombreRaza);
        TextView lblOrigenRaza = rowView.findViewById(R.id.lblOrigenRaza);
        TextView lblDescripcion = rowView.findViewById(R.id.lblDescripcionRaza);
        Raza objBoClass = this.listRaza.get(position);
        lblNombreRaza.setText(objBoClass.getStrRaza());
        lblOrigenRaza.setText(objBoClass.getStrOrigen());
        lblDescripcion.setText(objBoClass.getStrDescripcion());
        return rowView;
    }
}
