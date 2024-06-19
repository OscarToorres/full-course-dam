package com.example.practica04_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PreferencesActivity extends AppCompatActivity {

    SharedPreferences preferencias;
    EditText nombre, x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

         nombre = findViewById(R.id.nombre);
         x = findViewById(R.id.coordenadaX);
         y = findViewById(R.id.coordenadaY);
        Button aplicar = findViewById(R.id.aplicar);
        preferencias = getPreferences(0);

        nombre.setText(preferencias.getString("nombre",nombre.getText().toString()));
        x.setText((preferencias.getString("coordenadaX",x.getText().toString())));
        y.setText(preferencias.getString("coordenadaY", y.getText().toString()));

        aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPre = new Intent(PreferencesActivity.this,MainActivity.class);
                intPre.putExtra("nombre", nombre.getText().toString());
                intPre.putExtra("x",x.getText().toString());
                intPre.putExtra("y",y.getText().toString());

                startActivity(intPre);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferencias.edit() ;

        editor.putString("nombre", nombre.getText().toString());
        editor.putString("coordenadaX", x.getText().toString());
        editor.putString("coordenadaY",y.getText().toString());

        editor.commit();
    }
}