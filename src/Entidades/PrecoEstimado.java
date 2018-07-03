/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "preco_estimado")
@NamedQueries({
    @NamedQuery(name = "PrecoEstimado.findAll", query = "SELECT p FROM PrecoEstimado p")})
public class PrecoEstimado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrecoEstimadoPK precoEstimadoPK;
    @Basic(optional = false)
    @Column(name = "preco")
    private double preco;
    @JoinColumn(name = "flores_id_flor", referencedColumnName = "id_flor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Flores flores;

    public PrecoEstimado() {
    }

    public PrecoEstimado(PrecoEstimadoPK precoEstimadoPK) {
        this.precoEstimadoPK = precoEstimadoPK;
    }

    public PrecoEstimado(PrecoEstimadoPK precoEstimadoPK, double preco) {
        this.precoEstimadoPK = precoEstimadoPK;
        this.preco = preco;
    }

    public PrecoEstimado(int floresIdFlor, Date data) {
        this.precoEstimadoPK = new PrecoEstimadoPK(floresIdFlor, data);
    }

    public PrecoEstimadoPK getPrecoEstimadoPK() {
        return precoEstimadoPK;
    }

    public void setPrecoEstimadoPK(PrecoEstimadoPK precoEstimadoPK) {
        this.precoEstimadoPK = precoEstimadoPK;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Flores getFlores() {
        return flores;
    }

    public void setFlores(Flores flores) {
        this.flores = flores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (precoEstimadoPK != null ? precoEstimadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecoEstimado)) {
            return false;
        }
        PrecoEstimado other = (PrecoEstimado) object;
        if ((this.precoEstimadoPK == null && other.precoEstimadoPK != null) || (this.precoEstimadoPK != null && !this.precoEstimadoPK.equals(other.precoEstimadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PrecoEstimado[ precoEstimadoPK=" + precoEstimadoPK + " ]";
    }
    
}
