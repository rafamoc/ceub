package br.uniceub.ads.pdm.app_copa2026.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import br.uniceub.ads.pdm.app_copa2026.database.ddl.ConfiguracaoDDL;
import br.uniceub.ads.pdm.app_copa2026.database.ddl.EstadioDDL;
import br.uniceub.ads.pdm.app_copa2026.database.ddl.LinguaDDL;
import br.uniceub.ads.pdm.app_copa2026.database.dml.ConfiguracaoDML;
import br.uniceub.ads.pdm.app_copa2026.database.dml.EstadioDML;
import br.uniceub.ads.pdm.app_copa2026.database.dml.LinguaDML;

public class ConexaoSqlite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "copa2026.db";
    private static final int DATABASE_VERSION = 3;

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

        // Chamadas DML
        EstadioDML.insert(db);
        LinguaDML.insert(db);
        ConfiguracaoDML.insert(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Estadios");
        db.execSQL("DROP TABLE IF EXISTS Configuracao");
        db.execSQL("DROP TABLE IF EXISTS Linguas");
        onCreate(db);
    }
}