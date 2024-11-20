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

        // Inicializar los componentes de la vista
        alImg = findViewById(R.id.imvAlbum);
        alTit = findViewById(R.id.tvwAlbum);
        alArt = findViewById(R.id.tvwArt);
        alAnio = findViewById(R.id.tvwAni);
        alDes = findViewById(R.id.tvwDesc);

        // Obtener el ID del álbum desde el Intent
        Intent intent = getIntent();
        int albumId = intent.getIntExtra("album_id", -1); // Si no se pasa, retorna -1

        // Buscar el álbum por su ID
        Album album = getAlbumById(albumId);

        // Mostrar los datos del álbum en la vista
        if (album != null) {
            alImg.setImageResource(album.getIdImg());
            alTit.setText(album.getNombre());
            alArt.setText(album.getArtista());
            alAnio.setText(String.valueOf(album.getAnio()));

            StringBuilder descripcionCompleta = new StringBuilder();
            descripcionCompleta.append(album.getDescripcion());

            // Añadir las canciones al texto de descripción
            if (album.getCanciones() != null && !album.getCanciones().isEmpty()) {
                descripcionCompleta.append("\n\nCanciones:\n");
                for (String cancion : album.getCanciones()) {
                    descripcionCompleta.append(" - ").append(cancion).append("\n");
                }
            } else {
                descripcionCompleta.append("\n\nNo hay canciones disponibles.");
            }

            // Establecer el texto en el TextView
            alDes.setText(descripcionCompleta.toString());
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