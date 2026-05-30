package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class GrupoSelecaoDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Grupo_Selecao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_grupo INTEGER, " +
                "id_selecao INTEGER, " +
                "pontos INTEGER DEFAULT 0, " +
                "jogos INTEGER DEFAULT 0, " +
                "vitorias INTEGER DEFAULT 0, " +
                "empates INTEGER DEFAULT 0, " +
                "derrotas INTEGER DEFAULT 0, " +
                "gols_pro INTEGER DEFAULT 0, " +
                "gols_contra INTEGER DEFAULT 0, " +
                "saldo_gols INTEGER DEFAULT 0, " +
                "FOREIGN KEY(id_grupo) REFERENCES Grupos(id), " +
                "FOREIGN KEY(id_selecao) REFERENCES Selecoes(id));");
    }
}