/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Marcin
 */
@Entity
@Table(name = "samolot", catalog = "baza_lab_5_2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Samolot.findAll", query = "SELECT s FROM Samolot s")
    , @NamedQuery(name = "Samolot.findByIdsamolot", query = "SELECT s FROM Samolot s WHERE s.idsamolot = :idsamolot")
    , @NamedQuery(name = "Samolot.findByIdproducent", query = "SELECT s FROM Samolot s WHERE s.idproducent = :idproducent")
    , @NamedQuery(name = "Samolot.findByIdmodel", query = "SELECT s FROM Samolot s WHERE s.idmodel = :idmodel")
    , @NamedQuery(name = "Samolot.findByIdtyp", query = "SELECT s FROM Samolot s WHERE s.idtyp = :idtyp")
    , @NamedQuery(name = "Samolot.findByDataProdukcji", query = "SELECT s FROM Samolot s WHERE s.dataProdukcji = :dataProdukcji")
    , @NamedQuery(name = "Samolot.findByNumerSeryjny", query = "SELECT s FROM Samolot s WHERE s.numerSeryjny = :numerSeryjny")})
public class Samolot implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsamolot")
    private Integer idsamolot;
    @Basic(optional = false)
    @Column(name = "idproducent")
    private int idproducent;
    @Column(name = "idmodel")
    private Integer idmodel;
    @Column(name = "idtyp")
    private Integer idtyp;
    @Basic(optional = false)
    @Column(name = "data_produkcji")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProdukcji;
    @Basic(optional = false)
    @Column(name = "numer_seryjny")
    private String numerSeryjny;

    public Samolot() {
    }

    public Samolot(Integer idsamolot) {
        this.idsamolot = idsamolot;
    }

    public Samolot(Integer idsamolot, int idproducent, Date dataProdukcji, String numerSeryjny) {
        this.idsamolot = idsamolot;
        this.idproducent = idproducent;
        this.dataProdukcji = dataProdukcji;
        this.numerSeryjny = numerSeryjny;
    }

    public Integer getIdsamolot() {
        return idsamolot;
    }

    public void setIdsamolot(Integer idsamolot) {
        Integer oldIdsamolot = this.idsamolot;
        this.idsamolot = idsamolot;
        changeSupport.firePropertyChange("idsamolot", oldIdsamolot, idsamolot);
    }

    public int getIdproducent() {
        return idproducent;
    }

    public void setIdproducent(int idproducent) {
        int oldIdproducent = this.idproducent;
        this.idproducent = idproducent;
        changeSupport.firePropertyChange("idproducent", oldIdproducent, idproducent);
    }

    public Integer getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(Integer idmodel) {
        Integer oldIdmodel = this.idmodel;
        this.idmodel = idmodel;
        changeSupport.firePropertyChange("idmodel", oldIdmodel, idmodel);
    }

    public Integer getIdtyp() {
        return idtyp;
    }

    public void setIdtyp(Integer idtyp) {
        Integer oldIdtyp = this.idtyp;
        this.idtyp = idtyp;
        changeSupport.firePropertyChange("idtyp", oldIdtyp, idtyp);
    }

    public Date getDataProdukcji() {
        return dataProdukcji;
    }

    public void setDataProdukcji(Date dataProdukcji) {
        Date oldDataProdukcji = this.dataProdukcji;
        this.dataProdukcji = dataProdukcji;
        changeSupport.firePropertyChange("dataProdukcji", oldDataProdukcji, dataProdukcji);
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        String oldNumerSeryjny = this.numerSeryjny;
        this.numerSeryjny = numerSeryjny;
        changeSupport.firePropertyChange("numerSeryjny", oldNumerSeryjny, numerSeryjny);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsamolot != null ? idsamolot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samolot)) {
            return false;
        }
        Samolot other = (Samolot) object;
        if ((this.idsamolot == null && other.idsamolot != null) || (this.idsamolot != null && !this.idsamolot.equals(other.idsamolot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab5_2.Samolot[ idsamolot=" + idsamolot + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
