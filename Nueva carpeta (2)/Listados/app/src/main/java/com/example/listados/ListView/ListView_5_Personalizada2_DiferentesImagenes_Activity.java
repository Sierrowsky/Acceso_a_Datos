package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;
import com.example.listados.adaptadores.AdaptadorPersonalizado_1;

public class ListView_5_Personalizada2_DiferentesImagenes_Activity extends AppCompatActivity {
    private ListView lvPlanetas;
    private int[] arrayIdFotosPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view5_personalizada2_diferentes_imagenes);
        lvPlanetas = findViewById(R.id.lvPlanetas5);

        //auxiliar
        arrayIdFotosPlanetas = new int[] {
                R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte,
                R.drawable.jupiter, R.drawable.saturno, R.drawable.urano, R.drawable.neptuno
        };
        //crear instancia del adaptador personalizada
        AdaptadorPersonalizado_1 adaptador = new AdaptadorPersonalizado_1(this,
                R.layout.fila_diferentes_imagenes, getResources().getStringArray(R.array.planetas),
                arrayIdFotosPlanetas);
        //asignar adaptador a vista
        lvPlanetas.setAdapter(adaptador);
        //listener
        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView_5_Personalizada2_DiferentesImagenes_Activity.this,
                        "Planeta: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}