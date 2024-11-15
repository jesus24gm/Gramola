package com.example.gramola.Controladores;

import static android.os.Build.VERSION_CODES.R;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    EditText etPassw;
    EditText etNom;
    Button btnRegistro;
    EditText etFecNac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.gramola.R.layout.registro);

        etPassw=(EditText) findViewById(com.example.gramola.R.id.etPass);
        etNom=(EditText) findViewById(com.example.gramola.R.id.etNom);
        btnRegistro=(Button)findViewById(com.example.gramola.R.id.btnLog);
        etFecNac=(EditText) findViewById(com.example.gramola.R.id.etFecNac);

        etFecNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eligeFecha();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contr=etPassw.getText().toString();
                String fnacim=etFecNac.getText().toString();
                if (passOk(contr)&&mayor18(fnacim)){
                    Toast.makeText(Registro.this, "Registro completado correctamente", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(Registro.this,Inicio.class);
                    startActivity(in);
                } else if (!mayor18(fnacim)){
                    Toast.makeText(Registro.this, "Debes ser mayor de 18 para registrarte", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Registro.this, "Contraseña inválida. Debe tener al menos 8 caracteres, una mayúscula y un número o símbolo.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    private boolean passOk (String passw){
        String pass="^(?=.*[A-Z])(?=.*[0-9!@#$%^&*()_+=-])(?=\\S+$).{8,}$";
        return Pattern.matches(pass, passw);
    }
    private boolean mayor18(String fnac){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try{
            Date fnaci = sdf.parse(fnac);
            Calendar fact= Calendar.getInstance();//fecha actual
            Calendar fnacCal= Calendar.getInstance();//fecha de nacimiento
            fnacCal.setTime(fnaci);

            int edad= fact.get(Calendar.YEAR)- fnacCal.get(Calendar.YEAR);

            if(fact.get(Calendar.DAY_OF_YEAR)<fnacCal.get(Calendar.DAY_OF_YEAR)){
                edad--;//saber si el cumpleaños no ha ocurrido aún
            }
            return edad>=18;
        }catch (ParseException e){
            e.printStackTrace();
            Toast.makeText(this,"Formato de fecha incorrecto",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private void eligeFecha() {
        final Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int anioSeleccionado, int mesSeleccionado, int diaSeleccionado) {

                        String fechaSeleccionada = String.format("%02d/%02d/%04d", diaSeleccionado, mesSeleccionado + 1, anioSeleccionado);
                        etFecNac.setText(fechaSeleccionada);
                    }
                },
                anio, mes, dia
        );

        datePickerDialog.show();
    }
}