package com.rzt.carshopping.model;

import java.io.Serializable;

public class Carro implements Serializable {

    private Long id;

    private String nome;

    private String descricao;

    private String marca;

    private int quantidade;

    private int preco;

    private String imagem;

    public Carro() {
    }

    public Carro(Long id, String nome, String descricao, String marca, int quantidade, int preco, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.quantidade = quantidade;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
