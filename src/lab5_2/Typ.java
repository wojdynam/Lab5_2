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
@Table(name = "typ", catalog = "baza_lab_5_2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Typ.findAll", query = "SELECT t FROM Typ t")
    , @NamedQuery(name = "Typ.findByIdtyp", query = "SELECT t FROM Typ t WHERE t.idtyp = :idtyp")
    , @NamedQuery(name = "Typ.findByNazwa", query = "SELECT t FROM Typ t WHERE t.nazwa = :nazwa")})
public class Typ implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtyp")
    private Integer idtyp;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;

    public Typ() {
    }

    public Typ(Integer idtyp) {
        this.idtyp = idtyp;
    }

    public Typ(Integer idtyp, String nazwa) {
        this.idtyp = idtyp;
        this.nazwa = nazwa;
    }

    public Integer getIdtyp() {
        return idtyp;
    }

    public void setIdtyp(Integer idtyp) {
        Integer oldIdtyp = this.idtyp;
        this.idtyp = idtyp;
        changeSupport.firePropertyChange("idtyp", oldIdtyp, idtyp);
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
        hash += (idtyp != null ? idtyp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typ)) {
            return false;
        }
        Typ other = (Typ) object;
        if ((this.idtyp == null && other.idtyp != null) || (this.idtyp != null && !this.idtyp.equals(other.idtyp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab5_2.Typ[ idtyp=" + idtyp + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
