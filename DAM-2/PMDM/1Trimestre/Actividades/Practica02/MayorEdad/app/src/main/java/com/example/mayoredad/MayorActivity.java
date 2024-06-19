package com.example.mayoredad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MayorActivity extends AppCompatActivity {

    TextView mayorEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor);

        mayorEdad = findViewById(R.id.txtMayor);
        mayorEdad.setText("Ahora si " + (String) getIntent().getExtras().get("mayor")
                + ", acepta mi regalo");
    }
}