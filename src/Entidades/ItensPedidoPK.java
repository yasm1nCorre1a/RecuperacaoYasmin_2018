/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author a1712020
 */
@Embeddable
public class ItensPedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pedido_id_pedido")
    private int pedidoIdPedido;
    @Basic(optional = false)
    @Column(name = "flores_id_flor")
    private int floresIdFlor;

    public ItensPedidoPK() {
    }

    public ItensPedidoPK(int pedidoIdPedido, int floresIdFlor) {
        this.pedidoIdPedido = pedidoIdPedido;
        this.floresIdFlor = floresIdFlor;
    }

    public int getPedidoIdPedido() {
        return pedidoIdPedido;
    }

    public void setPedidoIdPedido(int pedidoIdPedido) {
        this.pedidoIdPedido = pedidoIdPedido;
    }

    public int getFloresIdFlor() {
        return floresIdFlor;
    }

    public void setFloresIdFlor(int floresIdFlor) {
        this.floresIdFlor = floresIdFlor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedidoIdPedido;
        hash += (int) floresIdFlor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPedidoPK)) {
            return false;
        }
        ItensPedidoPK other = (ItensPedidoPK) object;
        if (this.pedidoIdPedido != other.pedidoIdPedido) {
            return false;
        }
        if (this.floresIdFlor != other.floresIdFlor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ItensPedidoPK[ pedidoIdPedido=" + pedidoIdPedido + ", floresIdFlor=" + floresIdFlor + " ]";
    }
    
}
