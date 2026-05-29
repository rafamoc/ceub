package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class ConfiguracaoDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Configuracao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_lingua_selecionada INTEGER, " +
                "FOREIGN KEY(id_lingua_selecionada) REFERENCES Linguas(id));");
    }
}
