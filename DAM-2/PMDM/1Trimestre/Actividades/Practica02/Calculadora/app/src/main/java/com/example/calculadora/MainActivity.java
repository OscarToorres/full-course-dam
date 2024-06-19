package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Creacion de objetos de clase
    Integer n1,n2,suma;
    EditText numero1;
    EditText numero2;
    Button sumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencias a los botones de la interfaz
        numero1 = findViewById(R.id.Numero1);
        numero2 = findViewById(R.id.Numero2);
        sumar = findViewById(R.id.btnSumar);

        //Llamamos al listener
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, SumarActivity.class);

                n1 = Integer.parseInt(String.valueOf(numero1.getText()));
                n2 = Integer.parseInt(String.valueOf(numero2.getText()));
                suma = n1 + n2;

                intent.putExtra("SUMA", suma.toString());
                startActivity(intent);
            }
        });
    }
}