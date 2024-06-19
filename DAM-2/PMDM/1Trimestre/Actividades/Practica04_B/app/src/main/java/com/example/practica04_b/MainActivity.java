package com.example.practica04_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferencias;

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

        switch (item.getItemId()) {
            case R.id.preferencias:
                Intent intentPrefe = new Intent(MainActivity.this,PreferencesActivity.class);
                startActivity(intentPrefe);
                return true;
            case R.id.informacion:
                Intent intentInf = new Intent(MainActivity.this,AcercaDe.class);
                startActivity(intentInf);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}