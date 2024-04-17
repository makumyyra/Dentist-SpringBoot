package Lab24.hammaslaakari.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tooth_treatment")
public class ToothTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "toothid")
    private Tooth tooth;

    @ManyToOne
    @JoinColumn(name = "treatmentid")
    private Treatment treatment;

    @Column(name = "treatmentinfo")
    private String treatmentinfo;

    public Long getId() {
        return id;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getTreatmentInfo() {
        return treatmentinfo;
    }

    public void setTreatmentInfo(String treatmentInfo) {
        this.treatmentinfo = treatmentInfo;
    }

}
