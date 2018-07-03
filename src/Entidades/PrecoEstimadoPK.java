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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author a1712020
 */
@Embeddable
public class PrecoEstimadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "flores_id_flor")
    private int floresIdFlor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public PrecoEstimadoPK() {
    }

    public PrecoEstimadoPK(int floresIdFlor, Date data) {
        this.floresIdFlor = floresIdFlor;
        this.data = data;
    }

    public int getFloresIdFlor() {
        return floresIdFlor;
    }

    public void setFloresIdFlor(int floresIdFlor) {
        this.floresIdFlor = floresIdFlor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) floresIdFlor;
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecoEstimadoPK)) {
            return false;
        }
        PrecoEstimadoPK other = (PrecoEstimadoPK) object;
        if (this.floresIdFlor != other.floresIdFlor) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PrecoEstimadoPK[ floresIdFlor=" + floresIdFlor + ", data=" + data + " ]";
    }
    
}
