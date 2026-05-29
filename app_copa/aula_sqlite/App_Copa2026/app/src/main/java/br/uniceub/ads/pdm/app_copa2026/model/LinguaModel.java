package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoLingua;

public class LinguaModel {

    private ConexaoSqlite conexao;
    private SQLiteDatabase db;

    public LinguaModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    /**
     * Recupera o ID (chave primária) da tabela Linguas
     * baseado no valor da Enum CodigoLingua.
     */
    public int getIdLinguaPeloCodigo(CodigoLingua codigo) {
        int id = -1;
        db = conexao.getReadableDatabase();

        String sql = "SELECT id FROM Linguas WHERE codigo_lingua_enum = " + codigo.getValor();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            id = cursor.getInt(0); // Pega a primeira coluna (id)
        }

        cursor.close();
        db.close();
        return id;
    }
}