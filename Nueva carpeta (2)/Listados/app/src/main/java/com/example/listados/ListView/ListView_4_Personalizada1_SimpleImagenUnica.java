package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;

public class ListView_4_Personalizada1_SimpleImagenUnica extends AppCompatActivity {
    private ListView lvPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view4_personalizada_simple_imagen_unica);
        lvPlanetas = findViewById(R.id.lvPlanetas4);

        //adaptador del sistema con 4 parametros
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.fila_simple,
                R.id.tvPlaneta,
                getResources().getStringArray(R.array.planetas)
        );

        lvPlanetas.setAdapter(adapter);

        //listener

        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecionado = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView_4_Personalizada1_SimpleImagenUnica.this, selecionado, Toast.LENGTH_SHORT).show();

            }
        });
    }
}