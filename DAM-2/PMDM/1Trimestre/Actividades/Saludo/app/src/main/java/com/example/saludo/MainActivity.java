package com.example.saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtener una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtNombre);
        btnAceptar = findViewById(R.id.btnAceptar);
        //Daclaramos el listener para lo que queramos, en este caso el boton
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un intent en el que se le pasa la actividad en la que estamos y a la que queremos mandar
                Intent intent = new Intent(MainActivity.this, SaludoActivity.class);
                //El putExtra vale para pasarle los objetos o informacion que queramos
                intent.putExtra("USERNAME", txtNombre.getText().toString());
                //Para iniciar la actividad a la qu estamos llamando en el intent
                startActivity(intent);
            }
        });
    }
}