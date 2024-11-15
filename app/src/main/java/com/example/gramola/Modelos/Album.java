package com.example.gramola.Modelos;

import java.util.Objects;

public class Album {
    private String nombre;
    private String artista;
    private int año;
    private String descripcion;
    private int idImg;

    public Album(String nombre, String artista, int año, String descripcion, int idImg) {
        this.nombre = nombre;
        this.artista = artista;
        this.año = año;
        this.descripcion = descripcion;
        this.idImg = idImg;
    }

    public Album() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getAño() {
        return año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album abum = (Album) o;
        return año == abum.año && Objects.equals(nombre, abum.nombre) && Objects.equals(artista, abum.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, artista, año);
    }

    @Override
    public String toString() {
        return "Abum{" +
                "nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", año=" + año +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
