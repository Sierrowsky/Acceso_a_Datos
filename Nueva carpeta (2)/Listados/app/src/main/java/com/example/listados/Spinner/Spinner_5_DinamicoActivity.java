package com.example.listados.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listados.R;

import java.util.ArrayList;

public class Spinner_5_DinamicoActivity extends AppCompatActivity {
    private Spinner spDinamico;
    private EditText et_dato;
    private Button btn_dato, btn_mostrar;
    private ArrayList<String> arrayListDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner5_dinamico);
        spDinamico = findViewById(R.id.spDinamico);
        et_dato = findViewById(R.id.et_dato);
        btn_dato = findViewById(R.id.btn_dato);
        btn_mostrar = findViewById(R.id.btn_mostrar);

        arrayListDatos = new ArrayList<>();
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayListDatos);
        spDinamico.setAdapter(adaptador);

        //listener del boton
        btn_dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_dato.getText().toString().isEmpty()) {
                    Toast.makeText(Spinner_5_DinamicoActivity.this, "Teclee el dato", Toast.LENGTH_SHORT).show();
                } else {
                    /* if(spDinamico.getVisibility() == View.GONE) {
                        spDinamico.setVisibility(View.VISIBLE);
                    }*/
                    arrayListDatos.add(et_dato.getText().toString());
                    adaptador.notifyDataSetChanged();
                    Toast.makeText(Spinner_5_DinamicoActivity.this, et_dato.getText().toString() + " añadido al Spinner", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spDinamico.setVisibility(View.VISIBLE);
            }
        });

        spDinamico.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = spDinamico.getSelectedItem().toString();
                //podemos acceder al elemento seleccionado desde el propio adaptador
                String elemento_seleccionado_2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner_5_DinamicoActivity.this, "Has elegido " + elemento_seleccionado + "\n" + elemento_seleccionado_2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Acciones cuando no se selecciona ningún elemento
                Toast.makeText(Spinner_5_DinamicoActivity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
                //Toast.makeText(Spinner_2_Activity.this, "Ningún planeta seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}