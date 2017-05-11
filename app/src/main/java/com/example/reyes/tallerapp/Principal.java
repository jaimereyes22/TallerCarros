package com.example.reyes.tallerapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {

    ListView menu;
    String[] listaOpc;
    Resources res;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        menu = (ListView)findViewById(R.id.menu);
        res = getResources();
        listaOpc = res.getStringArray(R.array.opciones);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaOpc);
        menu.setAdapter(adapter);
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent ia = new Intent(Principal.this,Formulario.class);
                        startActivity(ia);
                        break;
                    case 1:
                        Intent ib = new Intent(Principal.this,Listado.class);
                        startActivity(ib);
                        break;
                    case 2:
                        Intent ic = new Intent(Principal.this,ListaReportes.class);
                        startActivity(ic);
                        break;
            }
            }
        });

    }



}
