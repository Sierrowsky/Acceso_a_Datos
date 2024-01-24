package com.example.listados.adaptadores;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listados.R;

public class AdaptadorPersonalizado_2 extends ArrayAdapter {
    private Activity context;
    private String[] arrayPlanetas;
    private TypedArray arrayIdFotosPlanetas;
    private int layout_personalizado;
    public AdaptadorPersonalizado_2(@NonNull Activity context, int layout_personalizado, String[] arrayPlanetas, TypedArray arrayIdFotosPlanetas) {
        //constructor defectivo
        super(context, layout_personalizado, arrayPlanetas);
        this.context = context;
        this.arrayPlanetas = arrayPlanetas;
        this.arrayIdFotosPlanetas = arrayIdFotosPlanetas;
        this.layout_personalizado = layout_personalizado;
    }//end AdaptadorPersonalizado_1

    //implementer el metodo getView

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(layout_personalizado, null);
        //capturamos los ids de cada componente de nuestro layout personalizado
        TextView tvPlaneta = fila.findViewById(R.id.tvPlaneta);
        TextView infoPlaneta = fila.findViewById(R.id.infoPlaneta);
        ImageView imgPlaneta = fila.findViewById(R.id.imgPlaneta);
        String infoplaneta = R.string.informacion + arrayPlanetas[position];
        //insertar cada valor (planeta/imagen) en su correspondiente id
        tvPlaneta.setText(arrayPlanetas[position]);
        infoPlaneta.setText(infoplaneta);

        // imgPlaneta.setImageResource(arrayIdFotosPlanetas[position]);
        //antes le pasabamos un entero(position) ahora le pasamos un drawable en la misma posicion
        imgPlaneta.setImageDrawable(arrayIdFotosPlanetas.getDrawable(position));
        return fila;
    }
}
