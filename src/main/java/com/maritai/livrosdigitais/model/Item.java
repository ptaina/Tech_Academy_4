package com.maritai.livrosdigitais.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "itens")

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "preco")
    private BigDecimal valor;

    @Column(name = "qtd_estoque")
    private Integer qtd_estoque;

    @ManyToOne
    @JoinColumn(name="categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    @Column(name = "escritor")
    private String escritor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }
}
