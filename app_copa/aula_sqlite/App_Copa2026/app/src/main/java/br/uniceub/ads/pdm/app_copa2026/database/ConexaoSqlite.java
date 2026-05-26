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

    private static final String CREATE_TABLE_SELECAO =
            "CREATE TABLE Selecao (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "pais TEXT NOT NULL);";

    private static final String CREATE_TABLE_PARTIDA =
            "CREATE TABLE Partida (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_selecao_1 INTEGER, " +
                    "gols_selecao1 INTEGER DEFAULT 0, " +
                    "id_selecao2 INTEGER, " +
                    "gols_selecao2 INTEGER DEFAULT 0, " +
                    "FOREIGN KEY(id_selecao_1) REFERENCES Selecao(id), " +
                    "FOREIGN KEY(id_selecao2) REFERENCES Selecao(id));";

    private static final String CREATE_TABLE_PARTIDA_ESTADIO =
            "CREATE TABLE Partida_Estadio (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_partida INTEGER, " +
                    "id_estadio INTEGER, " +
                    "data TEXT, " +
                    "FOREIGN KEY(id_partida) REFERENCES Partida(id), " +
                    "FOREIGN KEY(id_estadio) REFERENCES Estadios(id));";

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
        db.execSQL(CREATE_TABLE_SELECAO);
        db.execSQL(CREATE_TABLE_PARTIDA);
        db.execSQL(CREATE_TABLE_PARTIDA_ESTADIO);

        popularDadosIniciais(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Partida_Estadio");
        db.execSQL("DROP TABLE IF EXISTS Partida");
        db.execSQL("DROP TABLE IF EXISTS Selecao");
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        onCreate(db);
    }

    private void popularDadosIniciais(SQLiteDatabase db) {
        // Inserção das Seleções principais
        db.execSQL("INSERT INTO Selecao (pais) VALUES ('EUA');");
        db.execSQL("INSERT INTO Selecao (pais) VALUES ('Canadá');");
        db.execSQL("INSERT INTO Selecao (pais) VALUES ('México');");
        db.execSQL("INSERT INTO Selecao (pais) VALUES ('Brasil');");

        // EUA (Código 1 a 10)
        inserirEstadio(db, CodigoEstadios.ATLANTA, "Mercedes-Benz Stadium", "Atlanta", "estadio6_atlanta");
        inserirEstadio(db, CodigoEstadios.BOSTON, "Gillette Stadium", "Boston", "estadio7_boston");
        inserirEstadio(db, CodigoEstadios.DALLAS, "AT&T Stadium", "Dallas", "estadio8_dallas");
        inserirEstadio(db, CodigoEstadios.HOUSTON, "NRG Stadium", "Houston", "estadio9_houston");
        inserirEstadio(db, CodigoEstadios.KANSAS, "Arrowhead Stadium", "Kansas City", "estadio10_kansas");
        inserirEstadio(db, CodigoEstadios.MIAMI, "Hard Rock Stadium", "Miami", "estadio11_miami");
        inserirEstadio(db, CodigoEstadios.NOVA_YORK, "MetLife Stadium", "Nova York", "estadio12_novayork");
        inserirEstadio(db, CodigoEstadios.FILADELFIA, "Lincoln Financial Field", "Filadélfia", "estadio13_filadelfia");
        inserirEstadio(db, CodigoEstadios.SAN_FRANCISCO, "Levi's Stadium", "San Francisco", "estadio14_sanfrancisco");
        inserirEstadio(db, CodigoEstadios.SEATTLE, "Lumen Field", "Seattle", "estadio15_seattle");

        // CANADÁ (Código 11 a 12)
        inserirEstadio(db, CodigoEstadios.TORONTO, "BMO Field", "Toronto", "estadio1_toronto");
        inserirEstadio(db, CodigoEstadios.VANCOUVER, "BC Place", "Vancouver", "estadio2_vancouver");

        // MÉXICO (Código 13 a 15)
        inserirEstadio(db, CodigoEstadios.CIDADE_MEXICO, "Estádio Azteca", "Cidade do México", "estadio3_cidadedelmexico");
        inserirEstadio(db, CodigoEstadios.GUADALAJARA, "Estádio Akron", "Guadalajara", "estadio4_guadalajara");
        inserirEstadio(db, CodigoEstadios.MONTERREY, "Estádio BBVA", "Monterrey", "estadio5_monterrey");
    }

    private void inserirEstadio(SQLiteDatabase db, CodigoEstadios codigo, String nome, String local, String imagem) {
        String nomeEscape = nome.replace("'", "''");
        String sql = "INSERT INTO Estadios (codigo_estadio_enum, nome, local, imagem) VALUES (" +
                codigo.getValor() + ", '" + nomeEscape + "', '" + local + "', '" + imagem + "');";
        db.execSQL(sql);
    }
}