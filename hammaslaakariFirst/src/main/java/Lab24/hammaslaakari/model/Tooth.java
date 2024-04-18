package Lab24.hammaslaakari.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tooth")
public class Tooth {

    Treatment t;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "toothid", nullable = false, updatable = false)
    private Long toothId;

    @Column(name = "toothname", nullable = false, unique = true)
    private String toothname;

    // @OneToMany
    // @JoinColumn(name = "treatmentid")
    // private Long patientid = t.getTreatmentId();

    // @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "tooth")
    // private List<Treatment> treatments;

    @OneToMany(mappedBy = "tooth", cascade = CascadeType.ALL)
    private List<ToothTreatment> toothTreatments;

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

    // public List<Treatment> getToothTreatments() {
    // return treatments;
    // }

    // public void setToothTreatments(List<Treatment> treatments) {
    // this.treatments = treatments;
    // }

}
