package br.uniceub.ads.pdm.app_copa2026.pojo;

import java.io.Serializable;

public class GrupoSelecaoPojo implements Serializable {
    private int id;
    private int idGrupo;
    private int idSelecao;

    // Atributos vindos do JOIN com a tabela Selecoes
    private String nomeSelecao;
    private String siglaSelecao;
    private String escudoSelecao;

    // Estatísticas
    private int pontos;
    private int jogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private int saldoGols;

    public GrupoSelecaoPojo() {}

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdGrupo() { return idGrupo; }
    public void setIdGrupo(int idGrupo) { this.idGrupo = idGrupo; }

    public int getIdSelecao() { return idSelecao; }
    public void setIdSelecao(int idSelecao) { this.idSelecao = idSelecao; }

    public String getNomeSelecao() { return nomeSelecao; }
    public void setNomeSelecao(String nomeSelecao) { this.nomeSelecao = nomeSelecao; }

    public String getSiglaSelecao() { return siglaSelecao; }
    public void setSiglaSelecao(String siglaSelecao) { this.siglaSelecao = siglaSelecao; }

    public String getEscudoSelecao() { return escudoSelecao; }
    public void setEscudoSelecao(String escudoSelecao) { this.escudoSelecao = escudoSelecao; }

    public int getPontos() { return pontos; }
    public void setPontos(int pontos) { this.pontos = pontos; }

    public int getJogos() { return jogos; }
    public void setJogos(int jogos) { this.jogos = jogos; }

    public int getVitorias() { return vitorias; }
    public void setVitorias(int vitorias) { this.vitorias = vitorias; }

    public int getEmpates() { return empates; }
    public void setEmpates(int empates) { this.empates = empates; }

    public int getDerrotas() { return derrotas; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }

    public int getGolsPro() { return golsPro; }
    public void setGolsPro(int golsPro) { this.golsPro = golsPro; }

    public int getGolsContra() { return golsContra; }
    public void setGolsContra(int golsContra) { this.golsContra = golsContra; }

    public int getSaldoGols() { return saldoGols; }
    public void setSaldoGols(int saldoGols) { this.saldoGols = saldoGols; }
}