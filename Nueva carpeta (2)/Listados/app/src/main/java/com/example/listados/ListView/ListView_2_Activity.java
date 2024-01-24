package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;

public class ListView_2_Activity extends AppCompatActivity {
    private ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        lvPlanetas = findViewById(R.id.lvPlanetas2);

        //gestion del adaptador desde el recurso: forma 1
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_list_item_1);
        lvPlanetas.setAdapter(adaptador);

        //gestion del adaptador desde el recurso: forma 2
        //ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.planetas));
        //lvPlanetas.setAdapter(adaptador2);

        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView_2_Activity.this, "Has elegido " + elementoSeleccionado2, Toast.LENGTH_SHORT).show();
            }
        });
    }
}