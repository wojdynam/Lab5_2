/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Marcin
 */
@Entity
@Table(name = "model", catalog = "baza_lab_5_2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
    , @NamedQuery(name = "Model.findByIdmodel", query = "SELECT m FROM Model m WHERE m.idmodel = :idmodel")
    , @NamedQuery(name = "Model.findByNazwa", query = "SELECT m FROM Model m WHERE m.nazwa = :nazwa")})
public class Model implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmodel")
    private Integer idmodel;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;

    public Model() {
    }

    public Model(Integer idmodel) {
        this.idmodel = idmodel;
    }

    public Model(Integer idmodel, String nazwa) {
        this.idmodel = idmodel;
        this.nazwa = nazwa;
    }

    public Integer getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(Integer idmodel) {
        Integer oldIdmodel = this.idmodel;
        this.idmodel = idmodel;
        changeSupport.firePropertyChange("idmodel", oldIdmodel, idmodel);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        String oldNazwa = this.nazwa;
        this.nazwa = nazwa;
        changeSupport.firePropertyChange("nazwa", oldNazwa, nazwa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodel != null ? idmodel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.idmodel == null && other.idmodel != null) || (this.idmodel != null && !this.idmodel.equals(other.idmodel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab5_2.Model[ idmodel=" + idmodel + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
