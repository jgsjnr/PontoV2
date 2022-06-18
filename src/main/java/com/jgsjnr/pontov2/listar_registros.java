package com.jgsjnr.pontov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jgsjnr.pontov2.dao.PontoDAO;
import com.jgsjnr.pontov2.model.Genericos;
import com.jgsjnr.pontov2.model.Ponto;

import java.util.List;

public class listar_registros extends AppCompatActivity {

    private ListView listView;
    private PontoDAO pontoDAO;
    private Button btExportar;
    List<Ponto> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registros);
        listView = findViewById(R.id.lsView);
        pontoDAO = new PontoDAO(this);
        ls = pontoDAO.buscar();
        ArrayAdapter<Ponto> adaptr = new ArrayAdapter<Ponto>(this, android.R.layout.simple_list_item_1, ls);
        listView.setAdapter(adaptr);
        btExportar = findViewById(R.id.btExportar);
    }

    public void exportarTudo(View v){
        Genericos.sqliteExcel(ls);
    }
}