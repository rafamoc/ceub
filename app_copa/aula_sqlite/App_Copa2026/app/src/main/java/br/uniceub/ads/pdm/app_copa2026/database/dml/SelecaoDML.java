package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoSelecao;

public class SelecaoDML {
    public static void insert(SQLiteDatabase db) {
        // CONCACAF
        inserir(db, CodigoSelecao.CANADA, "Canadá", "CAN", "escudo_1");
        inserir(db, CodigoSelecao.ESTADOS_UNIDOS, "Estados Unidos", "USA", "escudo_2");
        inserir(db, CodigoSelecao.MEXICO, "México", "MEX", "escudo_3");
        inserir(db, CodigoSelecao.PANAMA, "Panamá", "PAN", "escudo_4");
        inserir(db, CodigoSelecao.COSTA_RICA, "Costa Rica", "CRC", "escudo_5");
        inserir(db, CodigoSelecao.JAMAICA, "Jamaica", "JAM", "escudo_6");

        // CONMEBOL
        inserir(db, CodigoSelecao.ARGENTINA, "Argentina", "ARG", "escudo_7");
        inserir(db, CodigoSelecao.BRASIL, "Brasil", "BRA", "escudo_8");
        inserir(db, CodigoSelecao.URUGUAI, "Uruguai", "URU", "escudo_9");
        inserir(db, CodigoSelecao.COLOMBIA, "Colômbia", "COL", "escudo_10");
        inserir(db, CodigoSelecao.EQUADOR, "Equador", "ECU", "escudo_11");
        inserir(db, CodigoSelecao.PARAGUAI, "Paraguai", "PAR", "escudo_12");
        inserir(db, CodigoSelecao.VENEZUELA, "Venezuela", "VEN", "escudo_13");

        // UEFA
        inserir(db, CodigoSelecao.FRANCA, "França", "FRA", "escudo_14");
        inserir(db, CodigoSelecao.INGLATERRA, "Inglaterra", "ENG", "escudo_15");
        inserir(db, CodigoSelecao.BELGICA, "Bélgica", "BEL", "escudo_16");
        inserir(db, CodigoSelecao.HOLANDA, "Holanda", "NED", "escudo_17");
        inserir(db, CodigoSelecao.PORTUGAL, "Portugal", "POR", "escudo_18");
        inserir(db, CodigoSelecao.ESPANHA, "Espanha", "ESP", "escudo_19");
        inserir(db, CodigoSelecao.ITALIA, "Itália", "ITA", "escudo_20");
        inserir(db, CodigoSelecao.ALEMANHA, "Alemanha", "GER", "escudo_21");
        inserir(db, CodigoSelecao.CROACIA, "Croácia", "CRO", "escudo_22");
        inserir(db, CodigoSelecao.SUICA, "Suíça", "SUI", "escudo_23");
        inserir(db, CodigoSelecao.DINAMARCA, "Dinamarca", "DEN", "escudo_24");
        inserir(db, CodigoSelecao.AUSTRIA, "Áustria", "AUT", "escudo_25");
        inserir(db, CodigoSelecao.UCRANIA, "Ucrânia", "UKR", "escudo_26");
        inserir(db, CodigoSelecao.TURQUIA, "Turquia", "TUR", "escudo_27");
        inserir(db, CodigoSelecao.POLONIA, "Polônia", "POL", "escudo_28");

        // CAF
        inserir(db, CodigoSelecao.MARROCOS, "Marrocos", "MAR", "escudo_29");
        inserir(db, CodigoSelecao.SENEGAL, "Senegal", "SEN", "escudo_30");
        inserir(db, CodigoSelecao.TUNISIA, "Tunísia", "TUN", "escudo_31");
        inserir(db, CodigoSelecao.ARGELIA, "Argélia", "ALG", "escudo_32");
        inserir(db, CodigoSelecao.EGITO, "Egito", "EGY", "escudo_33");
        inserir(db, CodigoSelecao.NIGERIA, "Nigéria", "NGR", "escudo_34");
        inserir(db, CodigoSelecao.CAMAROES, "Camarões", "CMR", "escudo_35");
        inserir(db, CodigoSelecao.COSTA_DO_MARFIM, "Costa do Marfim", "CIV", "escudo_36");
        inserir(db, CodigoSelecao.MALI, "Mali", "MLI", "escudo_37");

        // AFC
        inserir(db, CodigoSelecao.JAPAO, "Japão", "JPN", "escudo_38");
        inserir(db, CodigoSelecao.COREIA_DO_SUL, "Coreia do Sul", "KOR", "escudo_39");
        inserir(db, CodigoSelecao.IRA, "Irã", "IRN", "escudo_40");
        inserir(db, CodigoSelecao.AUSTRALIA, "Austrália", "AUS", "escudo_41");
        inserir(db, CodigoSelecao.ARABIA_SAUDITA, "Arábia Saudita", "KSA", "escudo_42");
        inserir(db, CodigoSelecao.IRAQUE, "Iraque", "IRQ", "escudo_43");
        inserir(db, CodigoSelecao.CATAR, "Catar", "QAT", "escudo_44");
        inserir(db, CodigoSelecao.UZBEQUISTAO, "Uzbequistão", "UZB", "escudo_45");

        // OFC e Repescagem
        inserir(db, CodigoSelecao.NOVA_ZELANDIA, "Nova Zelândia", "NZL", "escudo_46");
        inserir(db, CodigoSelecao.HONDURAS, "Honduras", "HON", "escudo_47");
        inserir(db, CodigoSelecao.CHILE, "Chile", "CHI", "escudo_48");
    }

    private static void inserir(SQLiteDatabase db, CodigoSelecao codigo, String nome, String sigla, String escudo) {
        db.execSQL("INSERT INTO Selecoes (codigo_selecao_enum, nome, sigla, escudo) VALUES (" +
                codigo.getValor() + ", '" + nome + "', '" + sigla + "', '" + escudo + "');");
    }
}