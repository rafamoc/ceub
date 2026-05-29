package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;

public class ConfiguracaoDML {
    public static void insert(SQLiteDatabase db) {
        db.execSQL("INSERT INTO Configuracao (id_lingua_selecionada) VALUES (NULL);");
    }
}
