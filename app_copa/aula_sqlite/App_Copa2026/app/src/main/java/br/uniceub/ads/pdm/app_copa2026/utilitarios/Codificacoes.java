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

    public enum CodigoSelecao {
        // --- AMÉRICA DO NORTE (CONCACAF) ---
        CANADA(1),
        ESTADOS_UNIDOS(2),
        MEXICO(3),
        PANAMA(4),
        COSTA_RICA(5),
        JAMAICA(6),

        // --- AMÉRICA DO SUL (CONMEBOL) ---
        ARGENTINA(7),
        BRASIL(8),
        URUGUAI(9),
        COLOMBIA(10),
        EQUADOR(11),
        PARAGUAI(12),
        VENEZUELA(13),

        // --- EUROPA (UEFA) ---
        FRANCA(14),
        INGLATERRA(15),
        BELGICA(16),
        HOLANDA(17),
        PORTUGAL(18),
        ESPANHA(19),
        ITALIA(20),
        ALEMANHA(21),
        CROACIA(22),
        SUICA(23),
        DINAMARCA(24),
        AUSTRIA(25),
        UCRANIA(26),
        TURQUIA(27),
        POLONIA(28),

        // --- ÁFRICA (CAF) ---
        MARROCOS(29),
        SENEGAL(30),
        TUNISIA(31),
        ARGELIA(32),
        EGITO(33),
        NIGERIA(34),
        CAMAROES(35),
        COSTA_DO_MARFIM(36),
        MALI(37),

        // --- ÁSIA (AFC) ---
        JAPAO(38),
        COREIA_DO_SUL(39),
        IRA(40),
        AUSTRALIA(41),
        ARABIA_SAUDITA(42),
        IRAQUE(43),
        CATAR(44),
        UZBEQUISTAO(45),

        // --- OCEANIA (OFC) ---
        NOVA_ZELANDIA(46),

        // --- REPESCAGEM / OUTROS ---
        HONDURAS(47),
        CHILE(48);

        private final int valor;

        CodigoSelecao(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        /**
         * Recupera a Enum a partir do valor inteiro armazenado no banco.
         */
        public static CodigoSelecao fromInt(int valor) {
            for (CodigoSelecao s : CodigoSelecao.values()) {
                if (s.getValor() == valor) {
                    return s;
                }
            }
            return null;
        }
    }
}