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
@Table(name = "producent", catalog = "baza_lab_5_2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producent.findAll", query = "SELECT p FROM Producent p")
    , @NamedQuery(name = "Producent.findByIdproducent", query = "SELECT p FROM Producent p WHERE p.idproducent = :idproducent")
    , @NamedQuery(name = "Producent.findByNazwa", query = "SELECT p FROM Producent p WHERE p.nazwa = :nazwa")})
public class Producent implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idproducent")
    private Integer idproducent;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;

    public Producent() {
    }

    public Producent(Integer idproducent) {
        this.idproducent = idproducent;
    }

    public Producent(Integer idproducent, String nazwa) {
        this.idproducent = idproducent;
        this.nazwa = nazwa;
    }

    public Integer getIdproducent() {
        return idproducent;
    }

    public void setIdproducent(Integer idproducent) {
        Integer oldIdproducent = this.idproducent;
        this.idproducent = idproducent;
        changeSupport.firePropertyChange("idproducent", oldIdproducent, idproducent);
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
        hash += (idproducent != null ? idproducent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producent)) {
            return false;
        }
        Producent other = (Producent) object;
        if ((this.idproducent == null && other.idproducent != null) || (this.idproducent != null && !this.idproducent.equals(other.idproducent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab5_2.Producent[ idproducent=" + idproducent + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
