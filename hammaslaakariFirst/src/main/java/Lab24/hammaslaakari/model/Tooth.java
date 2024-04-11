package Lab24.hammaslaakari.model;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tooth")
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toothid", nullable = false, updatable = false)
    private Long toothId;

    @Column(name = "toothname", nullable = false, unique = true)
    private String toothname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tooth")
    private List<Treatment> toothTreatments;

    public Tooth() {
        super();
    }

    public Tooth(String toothname) {
        super();
        this.toothname = toothname;
    }

    public Long getToothId() {
        return toothId;
    }

    public String getToothname() {
        return toothname;
    }

    public void setToothname(String toothname) {
        this.toothname = toothname;
    }

    public List<Treatment> getToothTreatments() {
        return toothTreatments;
    }

    public void setToothTreatments(List<Treatment> toothTreatments) {
        this.toothTreatments = toothTreatments;
    }

}
