package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;
import br.uniceub.ads.pdm.app_copa2026.pojo.SelecaoPojo;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoSelecao;

public class SelecaoModel {

    private SQLiteDatabase db;
    private ConexaoSqlite conexao;

    public SelecaoModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    /**
     * Busca uma seleção específica pelo seu código Enum.
     */
    public SelecaoPojo getSelecaoByCodigo(CodigoSelecao codigo) {
        SelecaoPojo pojo = null;
        db = conexao.getReadableDatabase();

        String sql = "SELECT * FROM Selecoes WHERE codigo_selecao_enum = " + codigo.getValor();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            pojo = carregarObjetoDoCursor(cursor);
        }

        cursor.close();
        db.close();
        return pojo;
    }

    /**
     * Retorna a lista de todas as 48 seleções.
     */
    public List<SelecaoPojo> listarTodas() {
        List<SelecaoPojo> lista = new ArrayList<>();
        db = conexao.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Selecoes ORDER BY nome ASC", null);

        while (cursor.moveToNext()) {
            lista.add(carregarObjetoDoCursor(cursor));
        }

        cursor.close();
        db.close();
        return lista;
    }

    /**
     * Mapeia os dados do Cursor para o objeto Pojo.
     */
    private SelecaoPojo carregarObjetoDoCursor(Cursor cursor) {
        SelecaoPojo pojo = new SelecaoPojo();
        pojo.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));

        int enumInt = cursor.getInt(cursor.getColumnIndexOrThrow("codigo_selecao_enum"));
        pojo.setCodigoSelecaoEnum(CodigoSelecao.fromInt(enumInt));

        pojo.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        pojo.setSigla(cursor.getString(cursor.getColumnIndexOrThrow("sigla")));
        pojo.setEscudo(cursor.getString(cursor.getColumnIndexOrThrow("escudo")));

        return pojo;
    }
}