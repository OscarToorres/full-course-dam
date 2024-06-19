package com.example.escogerfruta2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    EditText opciones;
    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imageView2);
        opciones = findViewById(R.id.edTxtOpciones);
        btnMostrar = findViewById(R.id.mostrar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String posiblesOpciones = opciones.getText().toString();
                if (posiblesOpciones.equals("a")){
                    imagen.setImageResource(R.mipmap.aguacate_foreground);
                }else if (posiblesOpciones.equals("c")){
                    imagen.setImageResource(R.mipmap.cereza_foreground);
                }else if (posiblesOpciones.equals("m")){
                    imagen.setImageResource(R.mipmap.manzana_foreground);
                }
            }
        });
    }
}