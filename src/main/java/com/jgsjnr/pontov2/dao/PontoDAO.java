package com.jgsjnr.pontov2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jgsjnr.pontov2.model.Conexao;
import com.jgsjnr.pontov2.model.Ponto;
import com.jgsjnr.pontov2.model.Conexao;

import java.util.ArrayList;
import java.util.List;

public class PontoDAO {
    private Conexao con;
    private SQLiteDatabase db;

    public PontoDAO(Context context){
        con = new Conexao(context);
        db = con.getWritableDatabase();
    }

    public long inserir(Ponto ponto){
        ContentValues a = new ContentValues();
        a.put("date", ponto.getDate());
        a.put("time", ponto.getTime());
        a.put("contexto", ponto.getContexto());
        return db.insert("ponto", null, a);
    }

    public List<Ponto> buscar(){
        List<Ponto> a = new ArrayList<>();
        Cursor cursor = db.query("ponto", new String[]{"id", "date", "time", "contexto"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            Ponto p = new Ponto();
            p.setId(cursor.getInt(0));
            p.setDate(cursor.getString(1));
            p.setTime(cursor.getString(2));
            p.setContexto(cursor.getString(3));
            a.add(p);
        }
        return a;
    }

}
