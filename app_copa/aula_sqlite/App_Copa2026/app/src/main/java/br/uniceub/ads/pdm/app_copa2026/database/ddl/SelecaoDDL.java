package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class SelecaoDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Selecoes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo_selecao_enum INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "sigla TEXT NOT NULL, " +
                "escudo TEXT NOT NULL);");
    }
}