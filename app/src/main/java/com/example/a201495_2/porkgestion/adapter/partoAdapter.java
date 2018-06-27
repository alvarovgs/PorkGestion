package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.Parto;

import java.util.ArrayList;

public class partoAdapter extends BaseAdapter{
    private Context appContext;
    private ArrayList<Parto> listaparto;
    public partoAdapter (Context appContext, ArrayList<Parto> listaparto) {
        this.appContext = appContext;
        this.listaparto = listaparto;
    }

    @Override
    public int getCount() {
        return listaparto.size();
    }

    @Override
    public Object getItem(int position) {
        return listaparto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<Parto> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listaparto.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_parto, parent, false);
        }
        TextView lblNombreCerdo = rowView.findViewById(R.id.lblNombreCerda);
        TextView lblFechaParto = rowView.findViewById(R.id.lblFechaParto);
        TextView lblCerdosVivos = rowView.findViewById(R.id.lblCerdosVivos);
        TextView lblCerdosMuertos = rowView.findViewById(R.id.lblCerdosMuertos);
        TextView lblIndiceMortalidad = rowView.findViewById(R.id.lblIndiceMortalidad);
        Parto objBoClass = this.listaparto.get(position);
        lblNombreCerdo.setText(String.format("Cerda: %s",objBoClass.getStrCodigoCerdo()));
        lblFechaParto.setText(String.format("Fecha Parto: %s",objBoClass.getStrFechaParto()));
        lblCerdosVivos.setText(String.format("Machos Vivos: %s - Hembras Vivas: %s ",String.valueOf(objBoClass.getVivosMachos()), String.valueOf(objBoClass.getVivosHembras())));
        lblCerdosMuertos.setText(String.format("Machos Muertos: %s - Hembras Muertas: %s ",String.valueOf(objBoClass.getMuertosMachos()), String.valueOf(objBoClass.getMuertosHembras())));
        lblIndiceMortalidad.setText(String.format("Ind. de mortalidad: %s ",String.valueOf(objBoClass.getIndicemortalidad()) ));
        return rowView;
    }
}
