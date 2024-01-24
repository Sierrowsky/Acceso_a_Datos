package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;
import com.example.listados.adaptadores.AdaptadorPersonalizado_1;
import com.example.listados.adaptadores.AdaptadorPersonalizado_2;

public class ListView_6_Personalizada2_DiferentesImagenes_TypedArray_Activity extends AppCompatActivity {

    private ListView lvPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6_personalizada2_diferentes_imagenes_typed_array);
        lvPlanetas = findViewById(R.id.lvPlanetas6);

        //crear instancia del adaptador personalizada
        AdaptadorPersonalizado_2 adaptador = new AdaptadorPersonalizado_2(this,
                R.layout.fila_diferentes_imagenes, getResources().getStringArray(R.array.planetas),
                getResources().obtainTypedArray(R.array.fotos_planetas));
        //asignar adaptador a vista
        lvPlanetas.setAdapter(adaptador);
        //listener
        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView_6_Personalizada2_DiferentesImagenes_TypedArray_Activity.this,
                        "Planeta: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}