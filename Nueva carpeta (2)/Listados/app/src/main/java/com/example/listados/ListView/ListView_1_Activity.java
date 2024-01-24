package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;

public class ListView_1_Activity extends AppCompatActivity {
    private ListView lvPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        lvPlanetas = findViewById(R.id.lvPlanetas1);

        //escuchador de la ListView
        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento_seleccionado = lvPlanetas.getItemAtPosition(position).toString();
                Toast.makeText(ListView_1_Activity.this, "Has elegido " + elemento_seleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}