package com.example.listados.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listados.R;

public class Spinner_1_Activity extends AppCompatActivity {
    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);
        spPlanetas = findViewById(R.id.spPlanetas1);

        //escuchador del spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = spPlanetas.getSelectedItem().toString();
                //podemos acceder al elemento seleccionado desde el propio adaptador
                String elemento_seleccionado_2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner_1_Activity.this, "Has elegido " + elemento_seleccionado + "\n" + elemento_seleccionado_2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Acciones cuando no se selecciona ningún elemento
                Toast.makeText(getApplicationContext(), "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Spinner_1_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}