package com.wtech.answeringcall;


import java.io.Serializable;

/**
 * Created by weldis on 29/08/16.
 */
public class Presenca {
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

}
