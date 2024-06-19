package com.example.registrosnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frase);

        TextView txtFrase = findViewById(R.id.txtFrase);

        String nombre = getIntent().getExtras().get("nombre").toString();
        String nota = getIntent().getExtras().get("nota").toString();

        Integer numerico = Integer.valueOf(nota);
        String frase;


        if(numerico >= 0 && numerico <= 4.99){
            frase = "El alumno " + nombre + " ha obtenido una calificacion de SUSPENSO en el modulo de PMDM";
        }else if (numerico >= 5 && numerico <= 5.99){
            frase = "El alumno " + nombre + " ha obtenido una calificacion de APROBADO en el modulo de PMDM";
        }else if (numerico >= 6 && numerico <= 6.99){
            frase = "El alumno " + nombre + " ha obtenido una calificacion de BIEN en el modulo de PMDM";
        }else if (numerico >= 7 && numerico <= 8.99) {
            frase = "El alumno " + nombre + " ha obtenido una calificacion de NOTABLE en el modulo de PMDM";
        }else {
            frase = "El alumno " + nombre + " ha obtenido una calificacion de SOBRESALIENTE en el modulo de PMDM";
        }

        txtFrase.setText(frase);

    }
}