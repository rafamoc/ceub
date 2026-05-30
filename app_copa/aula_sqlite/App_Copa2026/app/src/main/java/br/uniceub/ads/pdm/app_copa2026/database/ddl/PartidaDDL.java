package br.uniceub.ads.pdm.app_copa2026.database.ddl;

import android.database.sqlite.SQLiteDatabase;

public class PartidaDDL {
    public static void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Partidas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_grupo INTEGER, " +
                "id_selecao1 INTEGER, " +
                "id_selecao2 INTEGER, " +
                "gols_selecao1 INTEGER DEFAULT 0, " +
                "gols_selecao2 INTEGER DEFAULT 0, " +
                "data_hora TEXT, " +
                "status INTEGER DEFAULT 0, " + // 0: Agendada, 1: Em andamento, 2: Encerrada
                "FOREIGN KEY(id_grupo) REFERENCES Grupos(id), " +
                "FOREIGN KEY(id_selecao1) REFERENCES Selecoes(id), " +
                "FOREIGN KEY(id_selecao2) REFERENCES Selecoes(id));");
    }
}