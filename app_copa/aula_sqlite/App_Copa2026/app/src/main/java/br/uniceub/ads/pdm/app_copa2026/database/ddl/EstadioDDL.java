package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class EstadioDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Estadios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo_estadio_enum INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "local TEXT NOT NULL, " +
                "descricao TEXT, " +
                "data_fundacao TEXT, " +
                "capacidade INTEGER, " +
                "imagem TEXT NOT NULL, " +
                "link_maps TEXT);");
    }
}