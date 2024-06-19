package com.example.cribadeeratostenes;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class NumerosAdapter extends ArrayAdapter<NumerosAdapter> {

    public NumerosAdapter(@NonNull Context context, ArrayList<NumerosPrimos> numerosModelArrayList) {
        super(context, 0, numerosModelArrayList);
    }
}
