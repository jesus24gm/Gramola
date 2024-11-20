package com.example.gramola.Controladores;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
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
    private ActionMode am;
    private Album albSel;
    private int selPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        rv1 = findViewById(R.id.rv1);
        lsAlb = Utilidades.getAlbumlist();

        if (lsAlb != null && !lsAlb.isEmpty()) {
            Album_Ad ad = new Album_Ad(lsAlb);
            LinearLayoutManager llm1 = new LinearLayoutManager(this);
            rv1.setLayoutManager(llm1);
            rv1.setAdapter(ad);

            ad.setOnAlbumLongClickListener(new Album_Ad.OnAlbumLongClickListener() {
                @Override
                public void onAlbumLongClick(Album album, int position) {
                    if (am != null) {
                        return; // Si ya hay un Action Mode activo, no hace nada
                    }
                    albSel = album;
                    selPosition = position;
                    am = startSupportActionMode(actionModeCallback);
                }
            });
        }
    }

    private androidx.appcompat.view.ActionMode.Callback actionModeCallback = new androidx.appcompat.view.ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.menuaccion, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(androidx.appcompat.view.ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.option_delete) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Lista.this);
                builder.setTitle("Confirmar eliminación");
                builder.setMessage("¿Estás seguro de que deseas eliminar este álbum?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (selPosition >= 0 && selPosition < lsAlb.size()) {
                            lsAlb.remove(selPosition);
                            rv1.getAdapter().notifyItemRemoved(selPosition);
                            mode.finish();
                        } else {
                            Toast.makeText(Lista.this, "Error: posición inválida", Toast.LENGTH_SHORT).show();
                        }}
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Lista.this, "Acción cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(androidx.appcompat.view.ActionMode mode) {
            am = null;
            Toast.makeText(Lista.this, "Acción cancelada", Toast.LENGTH_SHORT).show();

        }
    };
}