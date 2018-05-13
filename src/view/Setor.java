/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Anderson
 */
@Entity
@Table(name = "setor", catalog = "Vendas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s")
    , @NamedQuery(name = "Setor.findBySetorid", query = "SELECT s FROM Setor s WHERE s.setorid = :setorid")
    , @NamedQuery(name = "Setor.findByNome", query = "SELECT s FROM Setor s WHERE s.nome = :nome")})
public class Setor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "setorid")
    private Integer setorid;
    @Column(name = "nome")
    private String nome;

    public Setor() {
    }

    public Setor(Integer setorid) {
        this.setorid = setorid;
    }

    public Integer getSetorid() {
        return setorid;
    }

    public void setSetorid(Integer setorid) {
        Integer oldSetorid = this.setorid;
        this.setorid = setorid;
        changeSupport.firePropertyChange("setorid", oldSetorid, setorid);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setorid != null ? setorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.setorid == null && other.setorid != null) || (this.setorid != null && !this.setorid.equals(other.setorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Setor[ setorid=" + setorid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
