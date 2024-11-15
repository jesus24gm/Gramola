package com.example.gramola.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gramola.Modelos.Album;
import com.example.gramola.R;

import java.util.ArrayList;

public class Album_Ad extends RecyclerView.Adapter<Album_Ad.AdAlbumHolder> {
    private ArrayList<Album> albAl;

    public Album_Ad(ArrayList<Album> albAl) {
        this.albAl = albAl;
    }

    @NonNull
    @Override
    public AdAlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.albumcard, parent, false);
        return new AdAlbumHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull AdAlbumHolder holder, int position) {
        Album al=albAl.get(position);
        holder.tvAlbum.setText(al.getNombre());
        holder.tvArtist.setText(al.getArtista());
        holder.tvAnnio.setText(String.valueOf(al.getAño()));
        holder.portada.setImageResource(al.getIdImg());

        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                holder.itemView.showContextMenu();
                return true;
            }
        };
        holder.itemView.setOnLongClickListener(longClickListener);

    }

    @Override
    public int getItemCount() {
        return albAl.size();
    }
    public static class AdAlbumHolder extends RecyclerView.ViewHolder {
        TextView tvAlbum, tvArtist, tvAnnio;
        ImageView portada;

        public AdAlbumHolder(View itemView) {
            super(itemView);
            tvAlbum = itemView.findViewById(R.id.tvNom);
            tvArtist = itemView.findViewById(R.id.tvBanda);
            tvAnnio = itemView.findViewById(R.id.tvAnio);
            portada=itemView.findViewById(R.id.ivPortada);
        }
    }
}
