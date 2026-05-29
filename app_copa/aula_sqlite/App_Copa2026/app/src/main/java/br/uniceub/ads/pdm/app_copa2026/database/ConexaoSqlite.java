package br.uniceub.ads.pdm.app_copa2026.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoEstadios;

public class ConexaoSqlite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "copa2026.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_ESTADIOS =
            "CREATE TABLE Estadios (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "codigo_estadio_enum INTEGER NOT NULL, " +
                    "nome TEXT NOT NULL, " +
                    "local TEXT NOT NULL, " +
                    "descricao TEXT, " +
                    "data_fundacao TEXT, " +
                    "capacidade INTEGER, " +
                    "imagem TEXT NOT NULL, " +
                    "link_maps TEXT);";



    public ConexaoSqlite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ESTADIOS);


        popularDadosIniciais(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        onCreate(db);
    }

    private void popularDadosIniciais(SQLiteDatabase db) {
        inserirEstadio(db, CodigoEstadios.TORONTO,
                "BMO Field", "Toronto, Canadá",
                "Estádio localizado em Toronto, uma das sedes canadenses da Copa do Mundo FIFA 2026.",
                "2007", 45000, "estadio1_toronto",
                "https://www.google.com/maps/search/?api=1&query=BMO+Field+Toronto");

        inserirEstadio(db, CodigoEstadios.VANCOUVER,
                "BC Place", "Vancouver, Canadá",
                "Estádio localizado em Vancouver, uma das sedes canadenses da Copa do Mundo FIFA 2026.",
                "1983", 54000, "estadio2_vancouver",
                "https://www.google.com/maps/search/?api=1&query=BC+Place+Vancouver");

        inserirEstadio(db, CodigoEstadios.CIDADE_MEXICO,
                "Estadio Azteca", "Cidade do México, México",
                "Estádio histórico da Cidade do México e uma das sedes mexicanas da Copa do Mundo FIFA 2026.",
                "1966", 83000, "estadio3_cidadedelmexico",
                "https://www.google.com/maps/search/?api=1&query=Estadio+Azteca+Mexico+City");

        inserirEstadio(db, CodigoEstadios.GUADALAJARA,
                "Estadio Akron", "Guadalajara, México",
                "Estádio localizado em Zapopan, região metropolitana de Guadalajara, uma das sedes mexicanas da Copa do Mundo FIFA 2026.",
                "2010", 48000, "estadio4_guadalajara",
                "https://www.google.com/maps/search/?api=1&query=Estadio+Akron+Guadalajara");

        inserirEstadio(db, CodigoEstadios.MONTERREY,
                "Estadio BBVA", "Monterrey, México",
                "Estádio localizado em Guadalupe, região metropolitana de Monterrey, uma das sedes mexicanas da Copa do Mundo FIFA 2026.",
                "2015", 53500, "estadio5_monterrey",
                "https://www.google.com/maps/search/?api=1&query=Estadio+BBVA+Monterrey");

        inserirEstadio(db, CodigoEstadios.ATLANTA,
                "Mercedes-Benz Stadium", "Atlanta, Estados Unidos",
                "Estádio localizado em Atlanta, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2017", 75000, "estadio6_atlanta",
                "https://www.google.com/maps/search/?api=1&query=Mercedes-Benz+Stadium+Atlanta");

        inserirEstadio(db, CodigoEstadios.BOSTON,
                "Gillette Stadium", "Boston, Estados Unidos",
                "Estádio localizado em Foxborough, região metropolitana de Boston, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2002", 65000, "estadio7_boston",
                "https://www.google.com/maps/search/?api=1&query=Gillette+Stadium+Foxborough");

        inserirEstadio(db, CodigoEstadios.DALLAS,
                "AT&T Stadium", "Dallas, Estados Unidos",
                "Estádio localizado em Arlington, região metropolitana de Dallas, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2009", 94000, "estadio8_dallas",
                "https://www.google.com/maps/search/?api=1&query=AT%26T+Stadium+Arlington+Texas");

        inserirEstadio(db, CodigoEstadios.HOUSTON,
                "NRG Stadium", "Houston, Estados Unidos",
                "Estádio localizado em Houston, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2002", 72000, "estadio9_houston",
                "https://www.google.com/maps/search/?api=1&query=NRG+Stadium+Houston");

        inserirEstadio(db, CodigoEstadios.KANSAS,
                "Arrowhead Stadium", "Kansas City, Estados Unidos",
                "Estádio localizado em Kansas City, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "1972", 73000, "estadio10_kansas",
                "https://www.google.com/maps/search/?api=1&query=Arrowhead+Stadium+Kansas+City");

        inserirEstadio(db, CodigoEstadios.MIAMI,
                "Hard Rock Stadium", "Miami, Estados Unidos",
                "Estádio localizado em Miami Gardens, região metropolitana de Miami, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "1987", 65000, "estadio11_miami",
                "https://www.google.com/maps/search/?api=1&query=Hard+Rock+Stadium+Miami+Gardens");

        inserirEstadio(db, CodigoEstadios.NOVA_YORK,
                "MetLife Stadium", "Nova York/Nova Jersey, Estados Unidos",
                "Estádio localizado em East Rutherford, Nova Jersey, sede da final da Copa do Mundo FIFA 2026.",
                "2010", 82500, "estadio12_novayork",
                "https://www.google.com/maps/search/?api=1&query=MetLife+Stadium+East+Rutherford");

        inserirEstadio(db, CodigoEstadios.FILADELFIA,
                "Lincoln Financial Field", "Filadélfia, Estados Unidos",
                "Estádio localizado na Filadélfia, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2003", 69000, "estadio13_filadelfia",
                "https://www.google.com/maps/search/?api=1&query=Lincoln+Financial+Field+Philadelphia");

        inserirEstadio(db, CodigoEstadios.SAN_FRANCISCO,
                "Levi's Stadium", "San Francisco Bay Area, Estados Unidos",
                "Estádio localizado em Santa Clara, região da Baía de San Francisco, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2014", 71000, "estadio14_sanfrancisco",
                "https://www.google.com/maps/search/?api=1&query=Levi%27s+Stadium+Santa+Clara");

        inserirEstadio(db, CodigoEstadios.SEATTLE,
                "Lumen Field", "Seattle, Estados Unidos",
                "Estádio localizado em Seattle, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2002", 69000, "estadio15_seattle",
                "https://www.google.com/maps/search/?api=1&query=Lumen+Field+Seattle");

        inserirEstadio(db, CodigoEstadios.LOS_ANGELES,
                "SoFi Stadium", "Los Angeles, Estados Unidos",
                "Estádio localizado em Inglewood, região metropolitana de Los Angeles, uma das sedes norte-americanas da Copa do Mundo FIFA 2026.",
                "2020", 70000, "estadio16_losangeles",
                "https://www.google.com/maps/search/?api=1&query=SoFi+Stadium+Inglewood");
    }

    private void inserirEstadio(SQLiteDatabase db, CodigoEstadios codigo, String nome, String local,
                                String descricao, String dataFundacao, int capacidade, String imagem, String linkMaps) {

        // Tratamento de aspas simples para nomes como Levi's Stadium
        String nomeEscaped = nome.replace("'", "''");
        String descEscaped = descricao.replace("'", "''");
        String localEscaped = local.replace("'", "''");

        String sql = "INSERT INTO Estadios (codigo_estadio_enum, nome, local, descricao, data_fundacao, capacidade, imagem, link_maps) " +
                "VALUES (" +
                codigo.getValor() + ", '" +
                nomeEscaped + "', '" +
                localEscaped + "', '" +
                descEscaped + "', '" +
                dataFundacao + "', " +
                capacidade + ", '" +
                imagem + "', '" +
                linkMaps + "');";

        db.execSQL(sql);
    }
}