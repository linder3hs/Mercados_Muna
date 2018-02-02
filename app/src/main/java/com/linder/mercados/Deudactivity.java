package com.linder.mercados;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Deudactivity extends AppCompatActivity {
    Button btndeuda;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deudactivity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btndeuda = (Button) findViewById(R.id.btnProbandodeuda);


        btndeuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Deudactivity.this, Detalle_Deuda_Activity.class);
                startActivity(intent);
            }
        });

        Spinner spinnerMercado = (Spinner) findViewById(R.id.spinnerMercado);
        Spinner spinnerMercado2 = (Spinner) findViewById(R.id.spinnerMercado2);

        // Spinner click listener
        spinnerMercado.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?>
                                               arg0, View arg1, int arg2, long arg3) {
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        // Elements of Spinner
        List<String> values = new ArrayList<String>();
        values.add("Estado");
        values.add("Minorista");
        values.add("Ramon Castilla");
        values.add("3 de Febrero");
        values.add("Mercado4");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Deudactivity.this, android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMercado.setAdapter(dataAdapter);

        spinnerMercado2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?>
                                               arg0, View arg1, int arg2, long arg3) {
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //Segundo Spinner
        // Elements of Spinner
        List<String> values2 = new ArrayList<String>();
        values2.add("Mercado");
        values2.add("Sant Rosa");
        values2.add("Segundo");
        values2.add("Prueba");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(Deudactivity.this, android.R.layout.simple_spinner_item, values2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMercado2.setAdapter(dataAdapter2);

    }

}