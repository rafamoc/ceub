package br.uniceub.ads.pdm.app_copa2026.utilitarios;

public class Codificacoes {

    public enum CodigoEstadios {
        ATLANTA(1),
        BOSTON(2),
        DALLAS(3),
        HOUSTON(4),
        KANSAS(5),
        MIAMI(6),
        NOVA_YORK(7),
        FILADELFIA(8),
        SAN_FRANCISCO(9),
        SEATTLE(10),
        TORONTO(11),
        VANCOUVER(12),
        CIDADE_MEXICO(13),
        GUADALAJARA(14),
        MONTERREY(15),
        LOS_ANGELES(16);

        private final int valor;
        CodigoEstadios(int valor) { this.valor = valor; }
        public int getValor() { return valor; }
    }

    public enum CodigoLingua {
        PORTUGUES(1),
        INGLES(2),
        ESPANHOL(3),
        FRANCES(4),
        ALEMAO(5),
        RUSSO(6),
        ITALIANO(7),
        JAPONES(8);


        private final int valor;
        CodigoLingua(int valor) { this.valor = valor; }
        public int getValor() { return valor; }
    }
}