package com.example.gramola.Controladores;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gramola.Adaptadores.Album_Ad;
import com.example.gramola.Modelos.Album;
import com.example.gramola.Modelos.Utilidades;
import com.example.gramola.R;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    private RecyclerView rv1;
    private ArrayList<Album> lsAlb;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);
        rv1=findViewById(R.id.rv1);
        rv1.setPadding(0,8,0,8);
        rv1.setClipToPadding(false);
        lsAlb= Utilidades.getAlbumlist();
        if (lsAlb!=null&&!lsAlb.isEmpty()){
            Album_Ad ad=new Album_Ad(lsAlb);
            LinearLayoutManager llm1= new LinearLayoutManager(this);
            rv1.setLayoutManager(llm1);
            rv1.setAdapter(ad);
        }else {
            Log.e("ListaActivity", "La lista de álbumes está vacía o nula.");
        }



    }


}

