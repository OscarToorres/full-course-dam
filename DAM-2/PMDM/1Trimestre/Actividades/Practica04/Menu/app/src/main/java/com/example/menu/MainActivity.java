package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView texto = findViewById(R.id.textView);
        switch (item.getItemId()) {
            case R.id.item1:
                texto.setText("No dejes para para mañana lo que puedes hacer hoy");
                return true;
            case R.id.item2:
                texto.setText("¿Cómo se dice no en Sudáfrica? Mopongo");
                return true;
            case R.id.item3:
                texto.setText("Ella no te ama");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}