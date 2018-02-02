package com.linder.mercados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetallePuestoRecaudacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_puesto_recaudacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
