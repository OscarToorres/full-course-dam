package com.example.mayoredad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    Button comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.cajaNombre);
        edad = findViewById(R.id.cajaEdad);
        comprobar = findViewById(R.id.comprobarEdad);

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer edadInt = Integer.parseInt(edad.getText().toString());
                if (edadInt < 18) {
                    Intent intentMenor = new Intent(MainActivity.this, MenorActivity.class);
                    intentMenor.putExtra("menor", nombre.getText().toString());

                    startActivity(intentMenor);
                } else {
                    Intent intentMayor = new Intent(MainActivity.this, MayorActivity.class);
                    intentMayor.putExtra("mayor", nombre.getText().toString());
                    startActivity(intentMayor);
                }
            }
        });
    }
}