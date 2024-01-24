package com.example.listados.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listados.R;

public class Spinner_2_Activity extends AppCompatActivity {
    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);
        spPlanetas = findViewById(R.id.spPlanetas2);

        String[] array_planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};

        //utilizar un adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, array_planetas);

        //asignar adaptador al spinner
        spPlanetas.setAdapter(adaptador);

        //escuchador del spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = spPlanetas.getSelectedItem().toString();
                //podemos acceder al elemento seleccionado desde el propio adaptador
                String elemento_seleccionado_2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner_2_Activity.this, "Has elegido " + elemento_seleccionado + "\n" + elemento_seleccionado_2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Acciones cuando no se selecciona ningún elemento
                Toast.makeText(Spinner_2_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Spinner_2_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}