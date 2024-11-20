package com.example.gramola.Controladores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gramola.Modelos.Album;
import com.example.gramola.Modelos.Utilidades;
import com.example.gramola.R;

public class Detalle extends AppCompatActivity {
    private ImageView alImg;
    private TextView alTit;
    private TextView alArt;
    private TextView alAnio;
    private TextView alDes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        alImg = findViewById(R.id.imvAlbum);
        alTit = findViewById(R.id.tvwAlbum);
        alArt = findViewById(R.id.tvwArt);
        alAnio = findViewById(R.id.tvwAni);
        alDes = findViewById(R.id.tvwDesc);

        Intent intent = getIntent();
        int albumId = intent.getIntExtra("album_id", -1); // Si no se pasa, retorna -1

        Album album = getAlbumById(albumId);

        // Mostrar los datos del álbum en la vista
        if (album != null) {
            alImg.setImageResource(album.getIdImg());
            alTit.setText(album.getNombre());
            alArt.setText(album.getArtista());
            alAnio.setText(String.valueOf(album.getAnio()));
            alDes.setText(album.getDescripcion());
            }
    }

    // Método para obtener el álbum por su ID
    private Album getAlbumById(int albumId) {
        for (Album album : Utilidades.getAlbumlist()) {
            if (album.getIdAlb() == albumId) {
                return album;
            }
        }
        return null;
    }
}