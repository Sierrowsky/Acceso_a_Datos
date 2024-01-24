package com.example.listados.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listados.R;

public class Spinner_3_ActivityDesdeRecurso extends AppCompatActivity {
    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner3);
        spPlanetas = findViewById(R.id.spPlanetas3);

        //metodo createFromResource
        //ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_spinner_dropdown_item);

        //capturando el recurso mediante getResources
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.planetas));

        spPlanetas.setAdapter(adaptador2);

        //escuchador del spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = spPlanetas.getSelectedItem().toString();
                //podemos acceder al elemento seleccionado desde el propio adaptador
                String elemento_seleccionado_2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner_3_ActivityDesdeRecurso.this, "Has elegido " + elemento_seleccionado + "\n" + elemento_seleccionado_2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Acciones cuando no se selecciona ningún elemento
                Toast.makeText(Spinner_3_ActivityDesdeRecurso.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Spinner_2_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}