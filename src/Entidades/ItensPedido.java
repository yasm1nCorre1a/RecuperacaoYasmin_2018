/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author a1712020
 */
@Entity
@Table(name = "itens_pedido")
@NamedQueries({
    @NamedQuery(name = "ItensPedido.findAll", query = "SELECT i FROM ItensPedido i")})
public class ItensPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensPedidoPK itensPedidoPK;
    @Basic(optional = false)
    @Column(name = "quant_itens_pedidos")
    private int quantItensPedidos;
    @Basic(optional = false)
    @Column(name = "preco_unitario")
    private String precoUnitario;
    @JoinColumn(name = "flores_id_flor", referencedColumnName = "id_flor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Flores flores;
    @JoinColumn(name = "pedido_id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    public ItensPedido() {
    }

    public ItensPedido(ItensPedidoPK itensPedidoPK) {
        this.itensPedidoPK = itensPedidoPK;
    }

    public ItensPedido(ItensPedidoPK itensPedidoPK, int quantItensPedidos, String precoUnitario) {
        this.itensPedidoPK = itensPedidoPK;
        this.quantItensPedidos = quantItensPedidos;
        this.precoUnitario = precoUnitario;
    }

    public ItensPedido(int pedidoIdPedido, int floresIdFlor) {
        this.itensPedidoPK = new ItensPedidoPK(pedidoIdPedido, floresIdFlor);
    }

    public ItensPedidoPK getItensPedidoPK() {
        return itensPedidoPK;
    }

    public void setItensPedidoPK(ItensPedidoPK itensPedidoPK) {
        this.itensPedidoPK = itensPedidoPK;
    }

    public int getQuantItensPedidos() {
        return quantItensPedidos;
    }

    public void setQuantItensPedidos(int quantItensPedidos) {
        this.quantItensPedidos = quantItensPedidos;
    }

    public String getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(String precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Flores getFlores() {
        return flores;
    }

    public void setFlores(Flores flores) {
        this.flores = flores;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensPedidoPK != null ? itensPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPedido)) {
            return false;
        }
        ItensPedido other = (ItensPedido) object;
        if ((this.itensPedidoPK == null && other.itensPedidoPK != null) || (this.itensPedidoPK != null && !this.itensPedidoPK.equals(other.itensPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ItensPedido[ itensPedidoPK=" + itensPedidoPK + " ]";
    }
    
}
