package com.example.gramola.Modelos;

import java.util.Objects;

public class Album {
    private int idAlb;
    private String nombre;
    private String artista;
    private int anio;
    private String descripcion;
    private int idImg;

    public Album(int idAlb,String nombre, String artista, int anio, String descripcion, int idImg) {
        this.idAlb=idAlb;
        this.nombre = nombre;
        this.artista = artista;
        this.anio = anio;
        this.descripcion = descripcion;
        this.idImg = idImg;
    }

    public Album() {
    }

    public int getIdAlb() {
        return idAlb;
    }

    public void setIdAlb(int idAlb) {
        this.idAlb = idAlb;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getAnio() {
        return anio;
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

    public void setAnio(int anio) {
        this.anio = anio;
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
        Album album = (Album) o;
        return idAlb == album.idAlb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAlb);
    }

    @Override
    public String toString() {
        return "Abum{" +
                "nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", año=" + anio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
