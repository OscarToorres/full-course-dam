package com.example.cribadeeratostenes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int n = 50;
        List<String> numeros = new CribaEratostenes().generaNumerosPrimos(n);
        GridView gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String> (this, R.layout.activity_numerosprimos, R.id.celdas, numeros);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                CharSequence cs = ((TextView) v).getText();
                if(!cs.equals(""))
                    Toast.makeText(getApplicationContext(),cs, Toast.LENGTH_SHORT).show();
            }
        });
    }
}