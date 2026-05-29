package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;

public class ConfiguracaoModel {

    private ConexaoSqlite conexao;
    private SQLiteDatabase db;

    public ConfiguracaoModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    public boolean isLinguaDefinida() {
        boolean definida = false;
        db = conexao.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id_lingua_selecionada FROM Configuracao LIMIT 1", null);

        if (cursor.moveToFirst()) {
            definida = !cursor.isNull(cursor.getColumnIndexOrThrow("id_lingua_selecionada"));
        }

        cursor.close();
        db.close();
        return definida;
    }

    // Método útil para salvar a escolha do usuário na SelecionarLinguaActivity
    public void salvarLinguaSelecionada(int idLingua) {
        db = conexao.getWritableDatabase();
        db.execSQL("UPDATE Configuracao SET id_lingua_selecionada = " + idLingua + " WHERE id = 1");
        db.close();
    }
}