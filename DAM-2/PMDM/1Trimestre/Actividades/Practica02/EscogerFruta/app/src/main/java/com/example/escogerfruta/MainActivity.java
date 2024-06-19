package com.example.escogerfruta;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnAguacates;
    Button btnCerezas;
    Button btnManzanas;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAguacates = findViewById(R.id.aguacate);
        btnCerezas = findViewById(R.id.cereza);
        btnManzanas = findViewById(R.id.manzana);
        imagen = findViewById(R.id.imageView2);

        btnAguacates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.setImageResource(R.mipmap.aguacate_foreground);

            }
        });
        btnCerezas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.setImageResource(R.mipmap.cerezas_foreground);

            }
        });
        btnManzanas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen.setImageResource(R.mipmap.manzanas_foreground);

            }
        });


    }
}