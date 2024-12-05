package com.maritai.livrosdigitais.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import java.util.Objects;

@Embeddable
public class ItemPedidoPK {

    @Column(name = "pedido_id")
    private Integer pedido_id;

    @Column(name = "item_id")
    private Integer item_id;

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }


    public ItemPedidoPK() {

    }
    public ItemPedidoPK(Integer pedido_id, Integer item_id) {
        this.pedido_id = pedido_id;
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // se for o mesmo objeto, são iguais.
        if (o == null || getClass() != o.getClass()) return false; // tá vendo se o objeto é nulo ou de classe diferente.
        ItemPedidoPK that = (ItemPedidoPK) o; // tá fazendo o cast para ItemPedidoPK(se falhar, não será executado).

        // tá verifricando a igualdade.
        return Objects.equals(pedido_id, that.pedido_id) &&
                Objects.equals(item_id, that.item_id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido_id, item_id);
    }
}
