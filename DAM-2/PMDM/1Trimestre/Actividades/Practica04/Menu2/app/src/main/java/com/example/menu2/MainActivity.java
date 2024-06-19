package com.example.menu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
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
        ImageView img = findViewById(R.id.frutas);
        switch (item.getItemId()) {
            case R.id.item11:
                img.setImageResource(R.mipmap.manzana_golden_foreground);
                return true;
            case R.id.item12:
                img.setImageResource(R.mipmap.manzana_verde_doncella_foreground);
                return true;
            case R.id.item2:
                img.setImageResource(R.mipmap.platanos_foreground);
                return true;
            case R.id.item31:
                img.setImageResource(R.mipmap.peras_conferencia_foreground);
                return  true;
            case R.id.item32:
                img.setImageResource(R.mipmap.peras_limoneras_foreground);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}