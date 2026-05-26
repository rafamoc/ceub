package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;
import br.uniceub.ads.pdm.app_copa2026.pojo.EstadioPojo;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoEstadios;

public class EstadioModel {

    private ConexaoSqlite conexao;
    private SQLiteDatabase db;

    public EstadioModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    public EstadioPojo getEstadioByCodigo(CodigoEstadios codigo) {
        db = conexao.getReadableDatabase();
        EstadioPojo estadio = null;

        String sql = "SELECT * FROM Estadios WHERE codigo_estadio_enum = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(codigo.getValor())});

        if (cursor.moveToFirst()) {
            estadio = carregarObjetoDoCursor(cursor);
        }

        cursor.close();
        db.close();
        return estadio;
    }

    public List<EstadioPojo> listarTodos() {
        db = conexao.getReadableDatabase();
        List<EstadioPojo> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM Estadios ORDER BY nome ASC", null);

        while (cursor.moveToNext()) {
            lista.add(carregarObjetoDoCursor(cursor));
        }

        cursor.close();
        db.close();
        return lista;
    }

    private EstadioPojo carregarObjetoDoCursor(Cursor cursor) {
        EstadioPojo e = new EstadioPojo();
        e.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        e.setCodigoEstadioEnum(cursor.getInt(cursor.getColumnIndexOrThrow("codigo_estadio_enum")));
        e.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        e.setLocal(cursor.getString(cursor.getColumnIndexOrThrow("local")));
        e.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow("descricao")));
        e.setDataFundacao(cursor.getString(cursor.getColumnIndexOrThrow("data_fundacao")));
        e.setCapacidade(cursor.getInt(cursor.getColumnIndexOrThrow("capacidade")));
        e.setImagem(cursor.getString(cursor.getColumnIndexOrThrow("imagem")));
        e.setLinkMaps(cursor.getString(cursor.getColumnIndexOrThrow("link_maps")));
        return e;
    }
}