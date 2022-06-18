package com.jgsjnr.pontov2.model;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.time.LocalDateTime;
public class Genericos {

    private static String atual;

    public String getAtual() {
        return atual;
    }

    public void setAtual(String atual) {
        this.atual = atual;
    }

    public static String dataAtual(){
        String data = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        /*
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        atual = formattedDate;

         */
        return data;
    }

    public static String horaAtual(){
        String hora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        return hora;
    }

    public static String dataHora(){
        String dataHora = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Calendar.getInstance().getTime());
        return  dataHora;
    }
    public static void sqliteExcel(List<Ponto> p){

        String col = "\"id\",\"date\",\"time\",\"contexto\"";

        File arqXLS;
        File root = Environment.getExternalStorageDirectory();
        File folder = new File(root.getAbsolutePath());
        folder.mkdirs();
        arqXLS = new File(folder, "Relatorio-"+Genericos.dataHora()+".csv");
        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream(arqXLS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            stream.write(col.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Ponto r: p){
            String s = "\n"+"\""+String.valueOf(r.getId())+"\","+
            "\""+r.getDate()+"\","+
            "\""+r.getTime()+"\",\""+r.getContexto()+"\"";
            try {
                stream.write(s.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
