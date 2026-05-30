package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;
import br.uniceub.ads.pdm.app_copa2026.pojo.GrupoPojo;

public class GrupoModel {

    private SQLiteDatabase db;
    private ConexaoSqlite conexao;

    public GrupoModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    /**
     * Retorna a lista de todos os grupos (A ao L).
     */
    public List<GrupoPojo> listarTodos() {
        List<GrupoPojo> lista = new ArrayList<>();
        db = conexao.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Grupos ORDER BY id ASC", null);

        while (cursor.moveToNext()) {
            lista.add(carregarObjetoDoCursor(cursor));
        }

        cursor.close();
        db.close();
        return lista;
    }

    /**
     * Busca um grupo específico pelo seu ID.
     */
    public GrupoPojo getGrupoById(int id) {
        GrupoPojo pojo = null;
        db = conexao.getReadableDatabase();

        String sql = "SELECT * FROM Grupos WHERE id = " + id;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            pojo = carregarObjetoDoCursor(cursor);
        }

        cursor.close();
        db.close();
        return pojo;
    }

    /**
     * Mapeia os dados do Cursor para o objeto Pojo.
     */
    private GrupoPojo carregarObjetoDoCursor(Cursor cursor) {
        GrupoPojo pojo = new GrupoPojo();
        pojo.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        pojo.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        return pojo;
    }
}