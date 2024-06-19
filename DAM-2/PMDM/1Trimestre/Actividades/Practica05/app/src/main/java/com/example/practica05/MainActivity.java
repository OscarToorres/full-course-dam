package com.example.practica05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BDHelper dbHelper;
    TextView numeroCita;
    EditText fecha, hora, asunto;
    Toast info;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
        dbHelper = new BDHelper(this);

        fecha = findViewById(R.id.fecha);
        hora = findViewById(R.id.hora);
        asunto = findViewById(R.id.asunto);
        numeroCita = findViewById(R.id.numeroCita);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Cita cita;
        db = dbHelper.getWritableDatabase();
        if (db != null) {
            switch (item.getItemId()) {
                case R.id.insertar:
                    try {
                        ContentValues cv = new ContentValues();
                        if (this.comprobarExistencia() == true) {
                            info.setText("El registro ya existe");
                        } else {
                            if (this.comprobarCampos() == false) {
                                info.setText("Campos obligatorios incompletos");
                            } else {
                                cv.put(BDSchema.Cita.COL_FECHA, fecha.getText().toString());
                                cv.put(BDSchema.Cita.COL_HORA, hora.getText().toString());
                                cv.put(BDSchema.Cita.COL_ASUNTO, asunto.getText().toString());
                                db.insert(BDSchema.Cita.TABLE_NAME, null, cv);
                                info.setText("Registro insertado");
                                this.limpiarFormato();
                            }
                        }

                    } catch (SQLException ex) {
                        info.setText("Algo salio mal");
                    }
                    info.show();
                    break;
                case R.id.borrar:
                    cita = this.obtenerCita();
                    long newRowId = db.delete(BDSchema.Cita.TABLE_NAME, BDSchema.Cita.COL_ID + " like '" + cita.getId() + "'", null);
                    if (newRowId == -1) {
                        info.setText("No hay ninguna cita que borrar");
                    } else {
                        info.setText("Cita borrada con exito");
                    }
                    this.limpiarFormato();
                    info.show();
                    break;
                case R.id.modificar:
                    if (this.comprobarCampos() == true) {
                        info.setText("Campos obligatorios incompletos");
                        cita = this.obtenerCita();
                        ContentValues cv = new ContentValues();
                        cv.put(BDSchema.Cita.COL_FECHA, fecha.getText().toString());
                        cv.put(BDSchema.Cita.COL_HORA, hora.getText().toString());
                        cv.put(BDSchema.Cita.COL_ASUNTO, asunto.getText().toString());

                        db.update(BDSchema.Cita.TABLE_NAME, cv, "id = '" + cita.getId() + "'", null);
                        info.setText("Cita modificada con exito");
                        this.limpiarFormato();
                    } else {
                        info.setText("Campos obligatorios incompletos");
                    }
                    info.show();
                    break;
                case R.id.consultar:
                    if (this.comprobarExistencia() == true){
                        cita = this.obtenerCita();
                        numeroCita.setText(cita.getId());
                        asunto.setText(cita.getAsunto());
                    } else {
                        info.setText("No hay ninguna cita");
                        info.show();
                    }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

    /*
    Este metodo devuelve un objeto cita filtrado por la hora y fecha introducidos en la aplicacion
    previamente introducido en la base de datos
    */
    private Cita obtenerCita() {
        Cursor c;
        Cita cita = new Cita();
        c = db.rawQuery("SELECT * FROM citas WHERE fecha like '" + fecha.getText().toString()
                + "' AND hora like '" + hora.getText().toString() + "'", null);

            while (c.moveToNext()) {
                cita.setId(c.getString(0));
                cita.setFehca(c.getString(1));
                cita.setHora(c.getString(2));
                cita.setAsunto(c.getString(3));

        }
        return cita;
    }

    private void limpiarFormato(){
        hora.setText("");
        fecha.setText("");
        numeroCita.setText("NumCita");
        asunto.setText("");
    }
    /*
    Devuelve true si existe la cita
     */
    private boolean comprobarExistencia(){
        Cursor c;
        c = db.rawQuery("SELECT * FROM citas WHERE fecha like '" + fecha.getText().toString()
                + "' AND hora like '" + hora.getText().toString() + "'", null);
        if (c.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
    /*
    Devuelve false si los campos obligatorios no estan completos
    */
    private boolean comprobarCampos(){
        if ("".equals(fecha.getText().toString()) || "".equals(hora.getText().toString())) {
            return false;
        } else {
            return true;
        }
    }
}