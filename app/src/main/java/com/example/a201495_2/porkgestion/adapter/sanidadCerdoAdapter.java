package com.example.a201495_2.porkgestion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a201495_2.porkgestion.R;
import com.example.a201495_2.porkgestion.bo_clases.SanidadCerdo;

import java.util.ArrayList;

public class sanidadCerdoAdapter extends BaseAdapter {
    private Context appContext;
    private ArrayList<SanidadCerdo> listSanidadCerdo;
    public sanidadCerdoAdapter(Context appContext, ArrayList<SanidadCerdo> listSanidadCerdo) {
        this.appContext = appContext;
        this.listSanidadCerdo = listSanidadCerdo;
    }

    @Override
    public int getCount() {
        return listSanidadCerdo.size();
    }

    @Override
    public Object getItem(int position) {
        return listSanidadCerdo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<SanidadCerdo> srrList) {
        for (int i = 0; i < srrList.size(); i++) {
            listSanidadCerdo.add(srrList.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        int idImage;
        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) appContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item_sanidadcerdo, parent, false);
        }
        TextView tvCodigoCerdo = rowView.findViewById(R.id.tvCodigoCerdo);
        TextView tvTipoMed = rowView.findViewById(R.id.tvTipoMed);
        TextView tvNombreMed = rowView.findViewById(R.id.tvNombreMed);
        TextView tvFechaAdmin = rowView.findViewById(R.id.tvFechaAdmin);
        TextView tvDosis = rowView.findViewById(R.id.tvDosis);
        TextView tvViaAdmin = rowView.findViewById(R.id.tvViaAdmin);
        ImageView imgSexo = rowView.findViewById(R.id.imgSexo);
        SanidadCerdo objBoClass = this.listSanidadCerdo.get(position);
        if(objBoClass.getStrSexoCerdo().equals("MACHO"))
            idImage = R.drawable.macho;
        else
            idImage = R.drawable.hembra;
        imgSexo.setImageResource(idImage) ;
        tvCodigoCerdo.setText(objBoClass.getStrCodigoCerdo());
        tvTipoMed.setText(objBoClass.getStrTipoMedicamento());
        tvNombreMed.setText(objBoClass.getStrNombreMedicamento());
        tvFechaAdmin.setText(objBoClass.getStrFechaAdministracion());
        tvDosis.setText(objBoClass.getStrDosis());
        tvViaAdmin.setText(objBoClass.getStrViaAdministracion());
        return rowView;
    }
}
