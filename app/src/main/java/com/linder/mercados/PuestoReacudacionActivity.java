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

public class PuestoReacudacionActivity extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();
    EditText date_initial, date_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puesto_reacudacion);
        date_initial = (EditText) findViewById(R.id.date_initial);
        date_final = (EditText) findViewById(R.id.date_final);
        Button btnp = (Button) findViewById(R.id.btnProbando);

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PuestoReacudacionActivity.this, DatosActivity.class);
                startActivity(intent);
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();
            }
        };


        date_initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PuestoReacudacionActivity.this, date,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
            }
        });

        date_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(PuestoReacudacionActivity.this, date2,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH))
                        .show();
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
        values.add("Concepto");
        values.add("Concepto");
        values.add("Concepto2");
        values.add("Concepto3");
        values.add("Concepto3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PuestoReacudacionActivity.this, android.R.layout.simple_spinner_item, values);
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
        values2.add("Minorista");
        values2.add("Ramon Castilla");
        values2.add("3 de Febrero");
        values2.add("Mercado4");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(PuestoReacudacionActivity.this, android.R.layout.simple_spinner_item, values2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMercado2.setAdapter(dataAdapter2);

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date_initial.setText(sdf.format(calendar.getTime()));
    }

    private void updateLabel2() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date_final.setText(sdf.format(calendar.getTime()));
    }
}