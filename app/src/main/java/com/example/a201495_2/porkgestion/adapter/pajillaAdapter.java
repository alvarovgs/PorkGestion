package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.Pajilla;

import java.util.ArrayList;

public class pajillaAdapter extends BaseAdapter{
    private Context appContext;
    private ArrayList<Pajilla> listPajilla;
    public pajillaAdapter(Context appContext, ArrayList<Pajilla> listPajilla) {
        this.appContext = appContext;
        this.listPajilla = listPajilla;
    }

    @Override
    public int getCount() {
        return listPajilla.size();
    }

    @Override
    public Object getItem(int position) {
        return listPajilla.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<Pajilla> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listPajilla.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_pajilla, parent, false);
        }
        TextView lblCodigoPajilla = rowView.findViewById(R.id.lblCodigoPajilla);
        TextView lblFechaVencimiento = rowView.findViewById(R.id.lblFechaVencimiento);
        TextView lblRazaPajilla = rowView.findViewById(R.id.lblRazaPajilla);
        Pajilla objBoClass = this.listPajilla.get(position);
        lblCodigoPajilla.setText(objBoClass.getStrCodigoPajilla());
        lblFechaVencimiento.setText(objBoClass.getStrFechaVence());
        lblRazaPajilla.setText(objBoClass.getStrNombreRaza());
        return rowView;
    }
}
