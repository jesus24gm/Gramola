package com.example.gramola.Adaptadores;

import android.view.ContextMenu;
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
    private OnAlbumLongClickListener longClickListener;

    public Album_Ad(ArrayList<Album> albAl) {
        this.albAl = albAl;
    }

    public void setOnAlbumLongClickListener(OnAlbumLongClickListener listener) {
        this.longClickListener = listener;
    }

    @NonNull
    @Override
    public AdAlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.albumcard, parent, false);
        return new AdAlbumHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull AdAlbumHolder holder, int position) {
        Album al = albAl.get(position);
        holder.tvAlbum.setText(al.getNombre());
        holder.tvArtist.setText(al.getArtista());
        holder.tvAnnio.setText(String.valueOf(al.getAño()));
        holder.portada.setImageResource(al.getIdImg());

        //  evento de pulsación larga
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickListener != null) {
                    int posAct = holder.getAdapterPosition(); // Obtener la posición actual
                    if (posAct != RecyclerView.NO_POSITION) {
                        longClickListener.onAlbumLongClick(al, posAct);
                        return true;
                    }
                }
                return false;
            }
        });
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
            portada = itemView.findViewById(R.id.ivPortada);
        }
    }

    public interface OnAlbumLongClickListener {
        void onAlbumLongClick(Album album, int position);
    }
}