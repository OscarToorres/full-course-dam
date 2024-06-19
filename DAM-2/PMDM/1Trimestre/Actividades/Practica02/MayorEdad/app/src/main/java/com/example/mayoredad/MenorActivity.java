package com.example.mayoredad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MenorActivity extends AppCompatActivity {

    TextView menorEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor);

        menorEdad = findViewById(R.id.txtMenor);
        menorEdad.setText("Los siento querido " + (String) getIntent().getExtras().get("menor")
                + " aun no puedes disfrutar de los privilegios de la libertad");

    }
}