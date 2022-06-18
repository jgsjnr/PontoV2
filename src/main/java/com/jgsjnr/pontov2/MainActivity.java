package com.jgsjnr.pontov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

import com.jgsjnr.pontov2.dao.PontoDAO;
import com.jgsjnr.pontov2.model.Genericos;
import com.jgsjnr.pontov2.model.Ponto;



public class MainActivity extends AppCompatActivity {

    Button btEntrada, btAlmoco, btFimAlmoco, btSaida, btLista;
    PontoDAO pontoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEntrada = findViewById(R.id.btEntrada);
        btAlmoco = findViewById(R.id.btAlmoco);
        btFimAlmoco = findViewById(R.id.btFimAlmoco);
        btSaida = findViewById(R.id.btSaida);
        btLista = findViewById(R.id.btLista);
        pontoDAO = new PontoDAO(this);
    }


    public void entrada(View v){
        Ponto p = new Ponto();
        p.setDate(Genericos.dataAtual());
        p.setTime(Genericos.horaAtual());
        p.setContexto("entrada");
        pontoDAO.inserir(p);
        Toast.makeText(this, "Inserido: "+p.getContexto(), Toast.LENGTH_SHORT).show();
    }
    public void almoco(View v){
        Ponto p = new Ponto();
        p.setDate(Genericos.dataAtual());
        p.setTime(Genericos.horaAtual());
        p.setContexto("Almoço");
        pontoDAO.inserir(p);
        Toast.makeText(this, "Inserido: "+p.getContexto(), Toast.LENGTH_SHORT).show();
    }
    public void fim_almoco(View v){
        Ponto p = new Ponto();
        p.setDate(Genericos.dataAtual());
        p.setTime(Genericos.horaAtual());
        p.setContexto("Fim Almoço");
        pontoDAO.inserir(p);
        Toast.makeText(this, "Inserido: "+p.getContexto(), Toast.LENGTH_SHORT).show();
    }
    public void saida(View v){
        Ponto p = new Ponto();
        p.setDate(Genericos.dataAtual());
        p.setTime(Genericos.horaAtual());
        p.setContexto("Saida");
        pontoDAO.inserir(p);
        Toast.makeText(this, "Inserido: "+p.getContexto(), Toast.LENGTH_SHORT).show();
    }

    public void ver_lista(View v){
        Intent intent = new Intent(this, listar_registros.class);
        startActivity(intent);
    }
}