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
@Table(name = "tarefa", catalog = "Vendas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t")
    , @NamedQuery(name = "Tarefa.findByTarefaid", query = "SELECT t FROM Tarefa t WHERE t.tarefaid = :tarefaid")
    , @NamedQuery(name = "Tarefa.findByData", query = "SELECT t FROM Tarefa t WHERE t.data = :data")
    , @NamedQuery(name = "Tarefa.findByValidade", query = "SELECT t FROM Tarefa t WHERE t.validade = :validade")
    , @NamedQuery(name = "Tarefa.findBySecretaria", query = "SELECT t FROM Tarefa t WHERE t.secretaria = :secretaria")
    , @NamedQuery(name = "Tarefa.findByTarefa", query = "SELECT t FROM Tarefa t WHERE t.tarefa = :tarefa")
    , @NamedQuery(name = "Tarefa.findByObservacao", query = "SELECT t FROM Tarefa t WHERE t.observacao = :observacao")
    , @NamedQuery(name = "Tarefa.findBySituacao", query = "SELECT t FROM Tarefa t WHERE t.situacao = :situacao")
    , @NamedQuery(name = "Tarefa.findBySetor", query = "SELECT t FROM Tarefa t WHERE t.setor = :setor")})
public class Tarefa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tarefaid")
    private Integer tarefaid;
    @Column(name = "data")
    private String data;
    @Column(name = "validade")
    private String validade;
    @Column(name = "secretaria")
    private String secretaria;
    @Column(name = "tarefa")
    private String tarefa;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "setor")
    private String setor;

    public Tarefa() {
    }

    public Tarefa(Integer tarefaid) {
        this.tarefaid = tarefaid;
    }

    public Integer getTarefaid() {
        return tarefaid;
    }

    public void setTarefaid(Integer tarefaid) {
        Integer oldTarefaid = this.tarefaid;
        this.tarefaid = tarefaid;
        changeSupport.firePropertyChange("tarefaid", oldTarefaid, tarefaid);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        String oldValidade = this.validade;
        this.validade = validade;
        changeSupport.firePropertyChange("validade", oldValidade, validade);
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        String oldSecretaria = this.secretaria;
        this.secretaria = secretaria;
        changeSupport.firePropertyChange("secretaria", oldSecretaria, secretaria);
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        String oldTarefa = this.tarefa;
        this.tarefa = tarefa;
        changeSupport.firePropertyChange("tarefa", oldTarefa, tarefa);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        String oldSituacao = this.situacao;
        this.situacao = situacao;
        changeSupport.firePropertyChange("situacao", oldSituacao, situacao);
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        String oldSetor = this.setor;
        this.setor = setor;
        changeSupport.firePropertyChange("setor", oldSetor, setor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarefaid != null ? tarefaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarefa)) {
            return false;
        }
        Tarefa other = (Tarefa) object;
        if ((this.tarefaid == null && other.tarefaid != null) || (this.tarefaid != null && !this.tarefaid.equals(other.tarefaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Tarefa[ tarefaid=" + tarefaid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
