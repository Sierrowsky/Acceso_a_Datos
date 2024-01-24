package com.example.listados.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;

import java.util.ArrayList;

public class Listview_3_Dinamica_Activity extends AppCompatActivity {
    private ListView lvPlanetas;
    private Button btnAdd;
    private EditText etPlanetas;
    private ArrayList<String> arrayListPlanetas;
    ArrayAdapter<String> adaptador2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3_dinamica);

        lvPlanetas = findViewById(R.id.lvPlanetas3);
        btnAdd = findViewById(R.id.btn_listview3);
        etPlanetas = findViewById(R.id.et_listview3);
        arrayListPlanetas =  new ArrayList<>();
        //gestion del adaptador desde el recurso: forma 1
//        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_list_item_1);
//        lvPlanetas.setAdapter(adaptador);

        //gestion del adaptador desde el recurso: forma 2
        adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.arrayListPlanetas);
        lvPlanetas.setAdapter(adaptador2);

        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText( Listview_3_Dinamica_Activity.this, "Has elegido " + elementoSeleccionado2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClickBtnListview3(View view) {
        if (view.getId() == R.id.btn_listview3){
            if (etPlanetas.getText().toString().isEmpty()) {
                Toast.makeText(Listview_3_Dinamica_Activity.this, "Teclee el dato", Toast.LENGTH_SHORT).show();
            } else {
                if (lvPlanetas.getVisibility() != View.VISIBLE) {
                    lvPlanetas.setVisibility(View.VISIBLE);
                }
                arrayListPlanetas.add(etPlanetas.getText().toString());
                adaptador2.notifyDataSetChanged();
                etPlanetas.setText("");
            }
        }
    }
}