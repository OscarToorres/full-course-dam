package com.example.saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saludo_activity); //Declarar el layout antes de trabajar con el
        TextView txt = findViewById(R.id.textView);
        /*
        Para trabajar con otras actividades tenemos que trabajar con los intent. Intetn,
        tiene un metodo que es getExtrax() que sirva para obtener todo lo que se para en el intent
        y a su vez el getExtras tiene otro metodo para buscar por el nombre con get(). Lo que
        obtenemos aqui es una especie de secuencia de caracteres que hay que pasar a string
        */
        txt.setText((String) getIntent().getExtras().get("USERNAME"));
        /*
        Esta seria otra forma que usamos el intent igualmente pero usamos el metodo getStringExtra()
        y buscamos por el nombre tambien. El problema de esta forma es que no pasa a string y si
        tenemos algo que no sea string del otro lado nos puede estropear el programa

        txt.setText(getIntent().getStringExtra("USERNAME"));
        */
    }
}