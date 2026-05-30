package br.uniceub.ads.pdm.app_copa2026.pojo;

import java.io.Serializable;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoSelecao;

public class SelecaoPojo implements Serializable {
    private int id;
    private CodigoSelecao codigoSelecaoEnum;
    private String nome;
    private String sigla;
    private String escudo;

    public SelecaoPojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CodigoSelecao getCodigoSelecaoEnum() {
        return codigoSelecaoEnum;
    }

    public void setCodigoSelecaoEnum(CodigoSelecao codigoSelecaoEnum) {
        this.codigoSelecaoEnum = codigoSelecaoEnum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
}