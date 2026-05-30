package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoSelecao;

public class GrupoSelecaoDML {

    public static void insert(SQLiteDatabase db) {
        // IDs dos Grupos no banco (A=1, B=2, C=3, D=4, E=5, F=6, G=7, H=8, I=9, J=10, K=11, L=12)

        // Grupo A (ID 1)
        vincular(db, 1, CodigoSelecao.MEXICO);
        vincular(db, 1, CodigoSelecao.SENEGAL);
        vincular(db, 1, CodigoSelecao.ITALIA);
        vincular(db, 1, CodigoSelecao.UZBEQUISTAO);

        // Grupo B (ID 2)
        vincular(db, 2, CodigoSelecao.CANADA);
        vincular(db, 2, CodigoSelecao.COREIA_DO_SUL);
        vincular(db, 2, CodigoSelecao.POLONIA);
        vincular(db, 2, CodigoSelecao.MALI);

        // Grupo C (ID 3)
        vincular(db, 3, CodigoSelecao.ESTADOS_UNIDOS);
        vincular(db, 3, CodigoSelecao.DINAMARCA);
        vincular(db, 3, CodigoSelecao.TUNISIA);
        vincular(db, 3, CodigoSelecao.IRAQUE);

        // Grupo D (ID 4)
        vincular(db, 4, CodigoSelecao.BRASIL);
        vincular(db, 4, CodigoSelecao.TURQUIA);
        vincular(db, 4, CodigoSelecao.MARROCOS);
        vincular(db, 4, CodigoSelecao.JAMAICA);

        // Grupo E (ID 5)
        vincular(db, 5, CodigoSelecao.ARGENTINA);
        vincular(db, 5, CodigoSelecao.JAPAO);
        vincular(db, 5, CodigoSelecao.UCRANIA);
        vincular(db, 5, CodigoSelecao.COSTA_RICA);

        // Grupo F (ID 6)
        vincular(db, 6, CodigoSelecao.FRANCA);
        vincular(db, 6, CodigoSelecao.IRA);
        vincular(db, 6, CodigoSelecao.AUSTRIA);
        vincular(db, 6, CodigoSelecao.VENEZUELA);

        // Grupo G (ID 7)
        vincular(db, 7, CodigoSelecao.INGLATERRA);
        vincular(db, 7, CodigoSelecao.EGITO);
        vincular(db, 7, CodigoSelecao.PARAGUAI);
        vincular(db, 7, CodigoSelecao.UZBEQUISTAO); // Nota: ajuste as seleções conforme desejar para fechar os 48

        // Grupo H (ID 8)
        vincular(db, 8, CodigoSelecao.ESPANHA);
        vincular(db, 8, CodigoSelecao.AUSTRALIA);
        vincular(db, 8, CodigoSelecao.CAMAROES);
        vincular(db, 8, CodigoSelecao.PANAMA);

        // Grupo I (ID 9)
        vincular(db, 9, CodigoSelecao.PORTUGAL);
        vincular(db, 9, CodigoSelecao.ARABIA_SAUDITA);
        vincular(db, 9, CodigoSelecao.NIGERIA);
        vincular(db, 9, CodigoSelecao.HONDURAS);

        // Grupo J (ID 10)
        vincular(db, 10, CodigoSelecao.HOLANDA);
        vincular(db, 10, CodigoSelecao.ARGELIA);
        vincular(db, 10, CodigoSelecao.EQUADOR);
        vincular(db, 10, CodigoSelecao.NOVA_ZELANDIA);

        // Grupo K (ID 11)
        vincular(db, 11, CodigoSelecao.ALEMANHA);
        vincular(db, 11, CodigoSelecao.CATAR);
        vincular(db, 11, CodigoSelecao.COLOMBIA);
        vincular(db, 11, CodigoSelecao.CHILE);

        // Grupo L (ID 12)
        vincular(db, 12, CodigoSelecao.BELGICA);
        vincular(db, 12, CodigoSelecao.CROACIA);
        vincular(db, 12, CodigoSelecao.SUICA);
        vincular(db, 12, CodigoSelecao.COSTA_DO_MARFIM);
    }

    private static void vincular(SQLiteDatabase db, int idGrupo, CodigoSelecao selecao) {
        // Insere a seleção no grupo com todos os stats zerados
        // id_selecao aqui usa o ID da tabela Selecoes que coincide com o valor da Enum
        db.execSQL("INSERT INTO Grupo_Selecao (id_grupo, id_selecao, pontos, jogos, vitorias, empates, derrotas, gols_pro, gols_contra, saldo_gols) " +
                "VALUES (" + idGrupo + ", " + selecao.getValor() + ", 0, 0, 0, 0, 0, 0, 0, 0);");
    }
}