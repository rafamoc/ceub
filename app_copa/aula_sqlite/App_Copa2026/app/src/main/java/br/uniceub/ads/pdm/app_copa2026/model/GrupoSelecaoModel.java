package br.uniceub.ads.pdm.app_copa2026.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import br.uniceub.ads.pdm.app_copa2026.database.ConexaoSqlite;
import br.uniceub.ads.pdm.app_copa2026.pojo.GrupoSelecaoPojo;

public class GrupoSelecaoModel {

    private SQLiteDatabase db;
    private ConexaoSqlite conexao;

    public GrupoSelecaoModel(Context context) {
        this.conexao = new ConexaoSqlite(context);
    }

    /**
     * Retorna a classificação de um grupo específico.
     * Realiza o JOIN com a tabela Selecoes para obter nomes e escudos.
     * Ordenação oficial: Pontos DESC, Saldo de Gols DESC, Gols Pró DESC.
     */
    public List<GrupoSelecaoPojo> listarClassificacaoPorGrupo(int idGrupo) {
        List<GrupoSelecaoPojo> lista = new ArrayList<>();
        db = conexao.getReadableDatabase();

        String sql = "SELECT gs.*, s.nome, s.sigla, s.escudo " +
                "FROM Grupo_Selecao gs " +
                "INNER JOIN Selecoes s ON gs.id_selecao = s.codigo_selecao_enum " +
                "WHERE gs.id_grupo = " + idGrupo + " " +
                "ORDER BY gs.pontos DESC, gs.saldo_gols DESC, gs.gols_pro DESC";

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            lista.add(carregarObjetoDoCursor(cursor));
        }

        cursor.close();
        db.close();
        return lista;
    }

    private GrupoSelecaoPojo carregarObjetoDoCursor(Cursor cursor) {
        GrupoSelecaoPojo pojo = new GrupoSelecaoPojo();

        pojo.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
        pojo.setIdGrupo(cursor.getInt(cursor.getColumnIndexOrThrow("id_grupo")));
        pojo.setIdSelecao(cursor.getInt(cursor.getColumnIndexOrThrow("id_selecao")));

        // Dados do JOIN
        pojo.setNomeSelecao(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        pojo.setSiglaSelecao(cursor.getString(cursor.getColumnIndexOrThrow("sigla")));
        pojo.setEscudoSelecao(cursor.getString(cursor.getColumnIndexOrThrow("escudo")));

        // Estatísticas
        pojo.setPontos(cursor.getInt(cursor.getColumnIndexOrThrow("pontos")));
        pojo.setJogos(cursor.getInt(cursor.getColumnIndexOrThrow("jogos")));
        pojo.setVitorias(cursor.getInt(cursor.getColumnIndexOrThrow("vitorias")));
        pojo.setEmpates(cursor.getInt(cursor.getColumnIndexOrThrow("empates")));
        pojo.setDerrotas(cursor.getInt(cursor.getColumnIndexOrThrow("derrotas")));
        pojo.setGolsPro(cursor.getInt(cursor.getColumnIndexOrThrow("gols_pro")));
        pojo.setGolsContra(cursor.getInt(cursor.getColumnIndexOrThrow("gols_contra")));
        pojo.setSaldoGols(cursor.getInt(cursor.getColumnIndexOrThrow("saldo_gols")));

        return pojo;
    }
}