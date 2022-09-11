package com.borja.t06_masterdetail.utils;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Tecnologia implements Serializable, Parcelable {

    private String nombre, caracteristicas;
    private int logo;

    public Tecnologia(String nombre, String caracteristicas, int logo) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.logo = logo;
    }

    protected Tecnologia(Parcel in) {
        nombre = in.readString();
        caracteristicas = in.readString();
        logo = in.readInt();
    }

    public static final Creator<Tecnologia> CREATOR = new Creator<Tecnologia>() {
        @Override
        public Tecnologia createFromParcel(Parcel in) {
            return new Tecnologia(in);
        }

        @Override
        public Tecnologia[] newArray(int size) {
            return new Tecnologia[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Tecnologia{" +
                "nombre='" + nombre + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", logo=" + logo +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(caracteristicas);
        parcel.writeInt(logo);
    }
}
