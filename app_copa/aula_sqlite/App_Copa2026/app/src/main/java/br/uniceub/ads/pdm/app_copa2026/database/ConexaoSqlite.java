package br.uniceub.ads.pdm.app_copa2026.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import br.uniceub.ads.pdm.app_copa2026.database.ddl.*;
import br.uniceub.ads.pdm.app_copa2026.database.dml.*;

public class ConexaoSqlite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "copa2026.db";
    private static final int DATABASE_VERSION = 5;

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
        // Chamadas DDL
        EstadioDDL.create(db);
        LinguaDDL.create(db);
        ConfiguracaoDDL.create(db);
        SelecaoDDL.create(db);
        GrupoDDL.create(db);
        PartidaDDL.create(db);
        GrupoSelecaoDDL.create(db);

        // Chamadas DML
        EstadioDML.insert(db);
        LinguaDML.insert(db);
        ConfiguracaoDML.insert(db);
        SelecaoDML.insert(db); // Novo
        GrupoDML.insert(db);
        GrupoSelecaoDML.insert(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Grupo_Selecao");
        db.execSQL("DROP TABLE IF EXISTS Partidas");
        db.execSQL("DROP TABLE IF EXISTS Grupos");
        db.execSQL("DROP TABLE IF EXISTS Selecoes");
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        db.execSQL("DROP TABLE IF EXISTS Configuracao");
        db.execSQL("DROP TABLE IF EXISTS Linguas");
        onCreate(db);
    }
}