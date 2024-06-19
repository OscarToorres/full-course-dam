package com.example.rellenardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class FraseActivity extends MainActivity {

    TextView txtViFrase;
    String nombre;
    String edad;
    String salario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase);

        txtViFrase = findViewById(R.id.txViFrase);

        Intent datos = getIntent();
        //Bundle guarda un mapa de String de llaves;
        Bundle llaves = datos.getExtras();
        nombre = llaves.get("valorNombre").toString();
        edad = llaves.get("valorEdad").toString();
        salario = llaves.get("valorSalario").toString();


        if (llaves.get("valorSexo").equals(R.id.radioHombre)) {
            txtViFrase.setText(nombre + " es un hombre de " + edad + " y tiene un salario de " + salario + " €");
        }else {
            txtViFrase.setText("Es una mujer");
            txtViFrase.setText(nombre + " es una mujer de " + edad + " y tiene un salario de " + salario + " €");
        }
    }
}