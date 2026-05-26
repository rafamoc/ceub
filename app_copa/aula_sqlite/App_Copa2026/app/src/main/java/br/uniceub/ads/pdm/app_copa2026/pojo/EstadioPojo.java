package br.uniceub.ads.pdm.app_copa2026.pojo;

import java.io.Serializable;

public class EstadioPojo implements Serializable {
    private int id;
    private int codigoEstadioEnum;
    private String nome;
    private String local;
    private String descricao;
    private String dataFundacao;
    private int capacidade;
    private String imagem;
    private String linkMaps;

    public EstadioPojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoEstadioEnum() {
        return codigoEstadioEnum;
    }

    public void setCodigoEstadioEnum(int codigoEstadioEnum) {
        this.codigoEstadioEnum = codigoEstadioEnum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLinkMaps() {
        return linkMaps;
    }

    public void setLinkMaps(String linkMaps) {
        this.linkMaps = linkMaps;
    }
}