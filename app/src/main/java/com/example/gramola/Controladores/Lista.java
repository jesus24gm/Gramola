package com.example.gramola.Controladores;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
        registerForContextMenu(rv1);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menuaccion, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option_delete) {
            return true;
        }
        return super.onContextItemSelected(item);
    }
}



