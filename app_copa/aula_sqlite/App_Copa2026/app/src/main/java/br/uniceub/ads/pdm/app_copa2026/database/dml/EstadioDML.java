package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoEstadios;

public class EstadioDML {
    public static void insert(SQLiteDatabase db) {
        inserir(db, CodigoEstadios.TORONTO, "BMO Field", "Toronto, Canadá", "Estádio sede canadense.", "2007", 45000, "estadio1_toronto", "https://...");
        inserir(db, CodigoEstadios.VANCOUVER, "BC Place", "Vancouver, Canadá", "Estádio sede canadense.", "1983", 54000, "estadio2_vancouver", "https://...");
        inserir(db, CodigoEstadios.CIDADE_MEXICO, "Estadio Azteca", "Cidade do México, México", "Estádio histórico.", "1966", 83000, "estadio3_cidadedelmexico", "https://...");
        inserir(db, CodigoEstadios.GUADALAJARA, "Estadio Akron", "Guadalajara, México", "Estádio sede mexicana.", "2010", 48000, "estadio4_guadalajara", "https://...");
        inserir(db, CodigoEstadios.MONTERREY, "Estadio BBVA", "Monterrey, México", "Estádio sede mexicana.", "2015", 53500, "estadio5_monterrey", "https://...");
        inserir(db, CodigoEstadios.ATLANTA, "Mercedes-Benz Stadium", "Atlanta, EUA", "Estádio sede americana.", "2017", 75000, "estadio6_atlanta", "https://...");
        inserir(db, CodigoEstadios.BOSTON, "Gillette Stadium", "Boston, EUA", "Estádio sede americana.", "2002", 65000, "estadio7_boston", "https://...");
        inserir(db, CodigoEstadios.DALLAS, "AT&T Stadium", "Dallas, EUA", "Estádio sede americana.", "2009", 94000, "estadio8_dallas", "https://...");
        inserir(db, CodigoEstadios.HOUSTON, "NRG Stadium", "Houston, EUA", "Estádio sede americana.", "2002", 72000, "estadio9_houston", "https://...");
        inserir(db, CodigoEstadios.KANSAS, "Arrowhead Stadium", "Kansas City, EUA", "Estádio sede americana.", "1972", 73000, "estadio10_kansas", "https://...");
        inserir(db, CodigoEstadios.MIAMI, "Hard Rock Stadium", "Miami, EUA", "Estádio sede americana.", "1987", 65000, "estadio11_miami", "https://...");
        inserir(db, CodigoEstadios.NOVA_YORK, "MetLife Stadium", "NY/NJ, EUA", "Sede da final.", "2010", 82500, "estadio12_novayork", "https://...");
        inserir(db, CodigoEstadios.FILADELFIA, "Lincoln Financial Field", "Filadélfia, EUA", "Estádio sede americana.", "2003", 69000, "estadio13_filadelfia", "https://...");
        inserir(db, CodigoEstadios.SAN_FRANCISCO, "Levi's Stadium", "San Francisco, EUA", "Estádio sede americana.", "2014", 71000, "estadio14_sanfrancisco", "https://...");
        inserir(db, CodigoEstadios.SEATTLE, "Lumen Field", "Seattle, EUA", "Estádio sede americana.", "2002", 69000, "estadio15_seattle", "https://...");
        inserir(db, CodigoEstadios.LOS_ANGELES, "SoFi Stadium", "LA, EUA", "Estádio sede americana.", "2020", 70000, "estadio16_losangeles", "https://...");
    }

    private static void inserir(SQLiteDatabase db, CodigoEstadios codigo, String nome, String local, String desc, String data, int cap, String img, String maps) {
        db.execSQL("INSERT INTO Estadios (codigo_estadio_enum, nome, local, descricao, data_fundacao, capacidade, imagem, link_maps) VALUES (" +
                codigo.getValor() + ", '" + nome.replace("'", "''") + "', '" + local.replace("'", "''") + "', '" +
                desc.replace("'", "''") + "', '" + data + "', " + cap + ", '" + img + "', '" + maps + "');");
    }
}