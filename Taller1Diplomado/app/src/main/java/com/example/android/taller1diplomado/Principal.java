package com.example.android.taller1diplomado;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {

    private EditText cantidad;
    private Spinner comboGenero;
    private Spinner comboEstilo;
    private Spinner comboMarca;
    private Intent i;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private String[] opc1;
    private String[] opc2;
    private String[] opc3;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cantidad = (EditText)findViewById(R.id.txtCantidad);
        comboGenero = (Spinner)findViewById(R.id.cmbGenero);
        comboEstilo = (Spinner)findViewById(R.id.cmbEstilo);
        comboMarca = (Spinner)findViewById(R.id.cmbMarca);

        res = this.getResources();

        opc1 = res.getStringArray(R.array.generos);
        opc2 = res.getStringArray(R.array.estilos);
        opc3 = res.getStringArray(R.array.marcas);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc1);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc3);

        comboGenero.setAdapter(adapter1);
        comboEstilo.setAdapter(adapter2);
        comboMarca.setAdapter(adapter3);

    }

    public void comprar(View v){
        String cant, genero, estilo, marca, aux="";
        int cant2=0, uni=0;

        if(validar()){
            cant = cantidad.getText().toString();
            cant2 = Integer.parseInt(cant);

            genero = comboGenero.getSelectedItem().toString();
            estilo = comboEstilo.getSelectedItem().toString();
            marca = comboMarca.getSelectedItem().toString();

            if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.nike))){
                uni = 120000;
                cant2 = cant2*uni;
            }
            if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.adidas))){
                uni = 140000;
                cant2 = cant2*uni;
            }
            if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.puma))){
                uni = 130000;
                cant2 = cant2*uni;
            }
            if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.nike))){
                uni = 50000;
                cant2 = cant2*uni;
            }
            if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.adidas))){
                uni = 80000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.hombre))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.puma))){
                uni = 100000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.nike))){
                uni = 100000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.adidas))){
                uni = 130000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.zapatilla))&&marca.equals(res.getString(R.string.puma))){
                uni = 110000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.nike))){
                uni = 60000;
                cant2 = cant2*uni;
            }if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.adidas))){
                uni = 70000;
                cant2 = cant2*uni;
            }
            if(genero.equals(res.getString(R.string.mujer))&&estilo.equals(res.getString(R.string.clasico))&&marca.equals(res.getString(R.string.puma))){
                uni = 120000;
                cant2 = cant2*uni;
            }

            aux = res.getString(R.string.unidad)+" "+uni+"\n"+res.getString(R.string.total)+" "+cant2+" "+res.getString(R.string.pesos);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(res.getString(R.string.result));
            builder.setMessage(aux)
                    .setCancelable(true);
            AlertDialog alert = builder.create();
            alert.show();
            limpiar();
        }
    }

    public boolean validar(){
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(res.getString(R.string.error));
            return false;
        }

        return true;
    }

    public void borrar(View v){
        limpiar();
    }

    public void limpiar(){
        cantidad.setText("");
    }

}
