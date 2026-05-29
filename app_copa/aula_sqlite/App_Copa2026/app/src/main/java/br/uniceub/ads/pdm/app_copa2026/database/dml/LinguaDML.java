package br.uniceub.ads.pdm.app_copa2026.database.dml;

import android.database.sqlite.SQLiteDatabase;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoLingua;

public class LinguaDML {
    public static void insert(SQLiteDatabase db) {
        inserir(db, CodigoLingua.PORTUGUES, "Português", "Bem-vindo à Copa 2026!");
        inserir(db, CodigoLingua.INGLES, "English", "Welcome to World Cup 2026!");
        inserir(db, CodigoLingua.ESPANHOL, "Español", "¡Bienvenido a la Copa 2026!");
        inserir(db, CodigoLingua.FRANCES, "Français", "Bienvenue à la Coupe 2026!");
        inserir(db, CodigoLingua.ALEMAO, "Deutsch", "Willkommen zur Weltmeisterschaft 2026!");
        inserir(db, CodigoLingua.RUSSO, "Русский", "Добро пожаловать na Kybok 2026!");
        inserir(db, CodigoLingua.ITALIANO, "Italiano", "Benvenuti alla Coppa 2026!");
        inserir(db, CodigoLingua.JAPONES, "日本語", "2026年ワールドカップへようこそ！");
    }

    private static void inserir(SQLiteDatabase db, CodigoLingua codigo, String nome, String msg) {
        db.execSQL("INSERT INTO Linguas (codigo_lingua_enum, nome, mensagem_boas_vindas) VALUES (" +
                codigo.getValor() + ", '" + nome + "', '" + msg + "');");
    }
}