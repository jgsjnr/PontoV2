package com.jgsjnr.pontov2.model;

import java.io.Serializable;

public class Ponto implements Serializable {

    String date;
    String time;
    String contexto;
    int id;



    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Data: " + date + " Hora: " + time + " Contexto: " + contexto;
    }
}
