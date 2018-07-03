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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author a1712020
 */
@Entity
@Table(name = "sexo")
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sexo")
    private Integer idSexo;
    @Basic(optional = false)
    @Column(name = "nome_sexo")
    private String nomeSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSexo")
    private List<Cliente> clienteList;

    public Sexo() {
    }

    public Sexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Sexo(Integer idSexo, String nomeSexo) {
        this.idSexo = idSexo;
        this.nomeSexo = nomeSexo;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getNomeSexo() {
        return nomeSexo;
    }

    public void setNomeSexo(String nomeSexo) {
        this.nomeSexo = nomeSexo;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSexo != null ? idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.idSexo == null && other.idSexo != null) || (this.idSexo != null && !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idSexo + "-"+nomeSexo;
    }
    
}
