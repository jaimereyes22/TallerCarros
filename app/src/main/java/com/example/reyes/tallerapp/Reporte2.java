package com.example.reyes.tallerapp;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte2 extends AppCompatActivity {

    private TextView numCarros;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte2);
        res = getResources();
        numCarros = (TextView)findViewById(R.id.nmarca);


        numCarros.setText(inicializarDatos() + "");
    }


    public String inicializarDatos(){
        ArrayList<Carro> personas = new ArrayList<>();
        Carro p;
        SQLiteDatabase db;
        String sql,placa,modelo,marca, color, resultado="No hay Vehiculos Registrados";
        int foto;
        double precio;
        CarroSQLite psoh = new CarroSQLite(this);
        db=psoh.getReadableDatabase();
        int mercedes =0;
        int ferrari = 0;
        int mitsubishi = 0;

        sql="Select foto,modelo,marca,placa,color,precio from Carros";
        Cursor c= db.rawQuery(sql, null);

        if(c.moveToFirst()){
            do{
                foto = c.getInt(0);
                modelo=c.getString(1);
                marca=c.getString(2);
                placa=c.getString(3);
                color=c.getString(4);
                precio=c.getDouble(5);
                p= new Carro(foto,modelo,marca,placa, color,precio);
                if(marca.equalsIgnoreCase( "Mercedes Benz")){
                    mercedes = mercedes+1;
                }
                if(marca.equalsIgnoreCase("Ferrari")){
                    ferrari += 1;
                }
                if(marca.equalsIgnoreCase( "Mitsubishi")){
                    mitsubishi += 1;
                }
                personas.add(p);
            }while(c.moveToNext());
        }
        resultado = "Mercedes = "+mercedes +"\n"+"Ferrari = "+ferrari +"\n"+"Mitsubishi = "+mitsubishi +"\n";
        return resultado;
    }


}
