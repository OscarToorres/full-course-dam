package com.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton rbCordoba;
    RadioButton rbZaragoza;
    RadioButton rbCaceres;
    RadioButton rbAvila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);

        rbCordoba = findViewById(R.id.cordoba);
        rbZaragoza = findViewById(R.id.zaragoza);
        rbCaceres = findViewById(R.id.caceres);
        rbAvila = findViewById(R.id.avila);

        ImageView ivCordoba = findViewById(R.id.ivCordoba);
        ImageView ivAvila = findViewById(R.id.ivAvila);
        ImageView ivCaceres = findViewById(R.id.ivCaceres);
        ImageView ivZaragoza = findViewById(R.id.ivZaragoza);

        ivCordoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobacion() == true) {
                    if (rbCordoba.isChecked()) {
                        tv.setText("Correcto");
                    } else {
                        tv.setText("Incorrecto");
                    }
                } else{
                    tv.setText("Primero marca una opcion");
                }

            }
        });

        ivAvila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobacion() == true) {

                    if (rbAvila.isChecked()){
                    tv.setText("Correcto");
                } else {
                    tv.setText("Incorrecto");
                }
                } else{
                    tv.setText("Primero marca una opcion");
                }
            }
        });

        ivCaceres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobacion() == true) {
                    if (rbCaceres.isChecked()){
                    tv.setText("Correcto");
                } else {
                    tv.setText("Incorrecto");
                }
                } else{
                    tv.setText("Primero marca una opcion");
                }
            }
        });

        ivZaragoza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comprobacion() == true) {

                    if (rbZaragoza.isChecked()){
                    tv.setText("Correcto");
                } else {
                    tv.setText("Incorrecto");
                }
            } else{
                tv.setText("Primero marca una opcion");
            }

                }
            }
        );

    }
    private boolean comprobacion(){
        boolean comprobar = false;
        if (rbAvila.isChecked() || rbCordoba.isChecked() || rbCaceres.isChecked() || rbZaragoza.isChecked()) {
            comprobar = true;
        }
        return comprobar;
    }
}