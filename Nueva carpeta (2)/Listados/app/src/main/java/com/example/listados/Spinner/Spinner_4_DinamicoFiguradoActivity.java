package com.example.listados.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listados.R;

import java.util.ArrayList;

public class Spinner_4_DinamicoFiguradoActivity extends AppCompatActivity {
    private Spinner spPlanetas;
    private ArrayList<String> arrayListPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner4);
        spPlanetas = findViewById(R.id.spPlanetas4);

        //simulamos la carga dinámica del string
        arrayListPlanetas = new ArrayList<>();
        arrayListPlanetas.add("Mercurio");
        arrayListPlanetas.add("Venus");
        arrayListPlanetas.add("Tierra");
        arrayListPlanetas.add("Marte");
        arrayListPlanetas.add("Júpiter");
        arrayListPlanetas.add("Saturno");
        arrayListPlanetas.add("Urano");
        arrayListPlanetas.add("Neptuno");

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayListPlanetas);

        spPlanetas.setAdapter(adaptador);

        //escuchador del spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = spPlanetas.getSelectedItem().toString();
                //podemos acceder al elemento seleccionado desde el propio adaptador
                String elemento_seleccionado_2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner_4_DinamicoFiguradoActivity.this, "Has elegido " + elemento_seleccionado + "\n" + elemento_seleccionado_2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Acciones cuando no se selecciona ningún elemento
                Toast.makeText(Spinner_4_DinamicoFiguradoActivity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Spinner_2_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}