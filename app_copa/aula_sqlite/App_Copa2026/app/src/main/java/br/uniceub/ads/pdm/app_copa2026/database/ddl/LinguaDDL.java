package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class LinguaDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Linguas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo_lingua_enum INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "mensagem_boas_vindas TEXT NOT NULL);");
    }
}