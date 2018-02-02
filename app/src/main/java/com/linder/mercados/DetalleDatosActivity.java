package com.linder.mercados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalleDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
