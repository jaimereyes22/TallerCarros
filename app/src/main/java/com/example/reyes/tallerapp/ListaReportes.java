package com.example.reyes.tallerapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaReportes extends AppCompatActivity {

    ListView reporte;
    String[] listaOpc;
    Resources res;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reportes);
        reporte = (ListView)findViewById(R.id.reportes);
        res = getResources();
        listaOpc = res.getStringArray(R.array.reportes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaOpc);
        reporte.setAdapter(adapter);
        reporte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent ia = new Intent(ListaReportes.this, Reporte1.class);
                        startActivity(ia);
                        break;
                    case 1:
                        Intent ib = new Intent(ListaReportes.this, Reporte2.class);
                        startActivity(ib);
                        break;
                    case 2:
                        Intent ic = new Intent(ListaReportes.this, Reporte3.class);
                        startActivity(ic);
                        break;
                    case 3:
                        Intent icc = new Intent(ListaReportes.this, Reporte4.class);
                        startActivity(icc);
                        break;
                    case 4:
                        Intent ie = new Intent(ListaReportes.this, Reporte5.class);
                        startActivity(ie);
                        break;
                    case 5:
                        Intent iee = new Intent(ListaReportes.this, Reporte6.class);
                        startActivity(iee);
                        break;
                }
            }
        });
    }
}
