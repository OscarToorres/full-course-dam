package com.example.registrosnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARACION DE VARIABLES
        EditText nombre = findViewById(R.id.editNombre);
        EditText modulo = findViewById(R.id.editModulo);
        EditText nota = findViewById(R.id.editNota);
        Button btn = findViewById(R.id.btnMostrar);

        TextView errorNota = findViewById(R.id.errorNota);
        TextView errorNombre = findViewById(R.id.errorNombre);
        TextView errorModulo = findViewById(R.id.errorModulo);

        //LISTENER
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer notaNumero = 0;

                //COMPROBACION DE TODOS LOS CAMPOS
                if (nombre.getText().toString().equals("") || !modulo.getText().toString().equals("PMDM") || nota.getText().toString().equals("") ) {
                    if (nombre.getText().toString().equals("")) {
                        errorNombre.setText("Valor de Nombre incorrecto");
                    } else {
                        errorNombre.setText("");
                    }
                    if (!modulo.getText().toString().equals("PMDM")) {
                        errorModulo.setText("Modulo incorrecto: Solo se admite PMDM");
                    } else {
                        errorModulo.setText("");
                    }
                    if (nota.getText().toString().equals("")) {
                        errorNota.setText("Introduce un valor entre 0-10");
                    }else {
                        notaNumero = Integer.valueOf(nota.getText().toString());
                        if (notaNumero > 0 && notaNumero < 10) {
                            errorNota.setText("Valor de nota inaceptado");
                        } else {
                            errorNota.setText("");
                        }
                    }

                } else {
                    Intent intent = new Intent(MainActivity.this, FraseActivity.class);
                    intent.putExtra("nombre", nombre.getText().toString());
                    intent.putExtra("nota", nota.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}