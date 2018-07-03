/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author a1712020
 */
@Entity
@Table(name = "flores")
@NamedQueries({
    @NamedQuery(name = "Flores.findAll", query = "SELECT f FROM Flores f")})
public class Flores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_flor")
    private Integer idFlor;
    @Basic(optional = false)
    @Column(name = "nome_flor")
    private String nomeFlor;
    @Basic(optional = false)
    @Column(name = "quantidade_flor")
    private int quantidadeFlor;
    @Basic(optional = false)
    @Column(name = "preco_flor")
    private double precoFlor;
    @Column(name = "caminho")
    private String caminho;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flores")
    private List<ItensPedido> itensPedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flores")
    private List<PrecoEstimado> precoEstimadoList;

    public Flores() {
    }

    public Flores(Integer idFlor) {
        this.idFlor = idFlor;
    }

    public Flores(Integer idFlor, String nomeFlor, int quantidadeFlor, double precoFlor) {
        this.idFlor = idFlor;
        this.nomeFlor = nomeFlor;
        this.quantidadeFlor = quantidadeFlor;
        this.precoFlor = precoFlor;
    }

    public Integer getIdFlor() {
        return idFlor;
    }

    public void setIdFlor(Integer idFlor) {
        this.idFlor = idFlor;
    }

    public String getNomeFlor() {
        return nomeFlor;
    }

    public void setNomeFlor(String nomeFlor) {
        this.nomeFlor = nomeFlor;
    }

    public int getQuantidadeFlor() {
        return quantidadeFlor;
    }

    public void setQuantidadeFlor(int quantidadeFlor) {
        this.quantidadeFlor = quantidadeFlor;
    }

    public double getPrecoFlor() {
        return precoFlor;
    }

    public void setPrecoFlor(double precoFlor) {
        this.precoFlor = precoFlor;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public List<ItensPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItensPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

    public List<PrecoEstimado> getPrecoEstimadoList() {
        return precoEstimadoList;
    }

    public void setPrecoEstimadoList(List<PrecoEstimado> precoEstimadoList) {
        this.precoEstimadoList = precoEstimadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFlor != null ? idFlor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flores)) {
            return false;
        }
        Flores other = (Flores) object;
        if ((this.idFlor == null && other.idFlor != null) || (this.idFlor != null && !this.idFlor.equals(other.idFlor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idFlor + "-"+nomeFlor;
    }
    
}
