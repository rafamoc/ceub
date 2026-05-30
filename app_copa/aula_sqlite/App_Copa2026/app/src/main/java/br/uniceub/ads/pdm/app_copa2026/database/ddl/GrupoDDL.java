package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class GrupoDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Grupos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL);"); // Ex: "Grupo A", "Grupo B"...
    }
}