package com.example.diego.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by diego on 5/16/15.
 */
public class User implements Parcelable {
    private String nombre;
    private String edad;
    private String estatura;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.edad);
        dest.writeString(this.estatura);
    }

    public User() {
    }

    public User(String nombre, String edad, String estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    private User(Parcel in) {
        this.nombre = in.readString();
        this.edad = in.readString();
        this.estatura = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
