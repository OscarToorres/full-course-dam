package com.example.rellenardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView aviso;
    EditText edTxNombre;
    EditText edTxEdad;
    EditText edTxSalario;
    Button btnMostrar;
    RadioGroup radioSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aviso = findViewById(R.id.txViAviso);
        edTxNombre = findViewById(R.id.edTxNombre);
        edTxEdad = findViewById(R.id.edTxEdad);
        edTxSalario = findViewById(R.id.edTxSalario);
        btnMostrar = findViewById(R.id.btnMostrar);
        radioSexo = findViewById(R.id.radioGroup);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFrase = new Intent(MainActivity.this, FraseActivity.class);

                String nombre = edTxNombre.getText().toString();
                String edad = edTxEdad.getText().toString();
                String salario = edTxSalario.getText().toString();

                if (nombre.equals("") || edad.equals("") || salario.equals("") || radioSexo.getCheckedRadioButtonId() == -1){
                    aviso.setText("Rellena todos los campos maquinote ;)");
                } else {
                    intentFrase.putExtra("valorNombre",edTxNombre.getText().toString());
                    intentFrase.putExtra("valorEdad",edTxEdad.getText().toString());
                    intentFrase.putExtra("valorSalario",edTxSalario.getText().toString());
                    intentFrase.putExtra("valorSexo",radioSexo.getCheckedRadioButtonId());
                    startActivity(intentFrase);
                }
            }
        });

    }
}