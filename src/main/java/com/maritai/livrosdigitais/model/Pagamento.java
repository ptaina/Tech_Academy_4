package com.maritai.livrosdigitais.model;

import jakarta.persistence.*;


@Entity
@Table(name = "pagamentos")

public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pagamento_id")
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedido_id;

    @Column(name = "forma_pg")
    private String formaPgto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(String formaPgto) {
        this.formaPgto = formaPgto;
    }
}
