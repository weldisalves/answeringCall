package com.wtech.answeringcall;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by weldis on 29/08/16.
 */
public class Presenca implements Parcelable {
    private int idParticipante;
    private String nome;
    private String  data;
    private String hora;
    private String status;

    public Presenca(){
        this.idParticipante = 0;
        this.nome = null;
        this.data = null;
        this.hora = null;
        this.status = null;
    }


    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    protected Presenca(Parcel in) {
        idParticipante = in.readInt();
        nome = in.readString();
        data = in.readString();
        hora = in.readString();
        status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idParticipante);
        dest.writeString(nome);
        dest.writeString(data);
        dest.writeString(hora);
        dest.writeString(status);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Presenca> CREATOR = new Parcelable.Creator<Presenca>() {
        @Override
        public Presenca createFromParcel(Parcel in) {
            return new Presenca(in);
        }

        @Override
        public Presenca[] newArray(int size) {
            return new Presenca[size];
        }
    };
}