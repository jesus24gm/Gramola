package com.example.gramola.Controladores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gramola.R;


public class Inicio extends AppCompatActivity {
        private Button btnRegistro;
        private Button btnLista;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.inicio);
            btnRegistro=(Button) findViewById(R.id.btnRegistro);
            btnLista=(Button) findViewById(R.id.btnLista);

            btnRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(Inicio.this,Registro.class);
                    startActivity(in);
                }
            });
            btnLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(Inicio.this,Lista.class);
                    startActivity(in);
                }
            });
        }
    }


