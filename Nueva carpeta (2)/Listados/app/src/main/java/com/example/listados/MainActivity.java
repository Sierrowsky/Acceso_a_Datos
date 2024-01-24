package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.listados.ListView.ListView_1_Activity;
import com.example.listados.ListView.ListView_2_Activity;
import com.example.listados.ListView.ListView_4_Personalizada1_SimpleImagenUnica;
import com.example.listados.ListView.ListView_5_Personalizada2_DiferentesImagenes_Activity;
import com.example.listados.ListView.ListView_6_Personalizada2_DiferentesImagenes_TypedArray_Activity;
import com.example.listados.ListView.Listview_3_Dinamica_Activity;
import com.example.listados.Spinner.Spinner_1_Activity;
import com.example.listados.Spinner.Spinner_2_Activity;
import com.example.listados.Spinner.Spinner_3_ActivityDesdeRecurso;
import com.example.listados.Spinner.Spinner_4_DinamicoFiguradoActivity;
import com.example.listados.Spinner.Spinner_5_DinamicoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnListados(View view) {
        Intent i = new Intent();
        switch (view.getId()) {
            //gestion de spinner
            case R.id.btn1_spinner:
                i.setClass(this, Spinner_1_Activity.class);
                break;
            case R.id.btn2_spinner:
                i.setClass(this, Spinner_2_Activity.class);
                break;
            case R.id.btn3_spinner:
                i.setClass(this, Spinner_3_ActivityDesdeRecurso.class);
                break;
            case R.id.btn4_spinner:
                i.setClass(this, Spinner_4_DinamicoFiguradoActivity.class);
                break;
            case R.id.btn5_spinner:
                i.setClass(this, Spinner_5_DinamicoActivity.class);
                break;
            //gestion de ListView
            case R.id.btn1_listview:
                i.setClass(this, ListView_1_Activity.class);
                break;
            case R.id.btn2_listview:
                i.setClass(this, ListView_2_Activity.class);
                break;
            case R.id.btn3_listview:
                i.setClass(this, Listview_3_Dinamica_Activity.class);
                break;
            case R.id.btn4_listview:
                i.setClass(this, ListView_4_Personalizada1_SimpleImagenUnica.class);
                break;
            case R.id.btn5_listview:
                i.setClass(this, ListView_5_Personalizada2_DiferentesImagenes_Activity.class);
                break;
            case R.id.btn6_listview:
                i.setClass(this, ListView_6_Personalizada2_DiferentesImagenes_TypedArray_Activity.class);
                break;

        }//end switch
        llamarActivity(i);
    }

    private void llamarActivity(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {//irresoluble
            Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();
        }
    }
}