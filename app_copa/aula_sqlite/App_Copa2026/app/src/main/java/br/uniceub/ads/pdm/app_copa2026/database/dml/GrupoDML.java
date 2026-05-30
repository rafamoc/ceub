package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;

public class GrupoDML {
    public static void insert(SQLiteDatabase db) {
        String[] grupos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        for (String g : grupos) {
            db.execSQL("INSERT INTO Grupos (nome) VALUES ('Grupo " + g + "');");
        }
    }
}