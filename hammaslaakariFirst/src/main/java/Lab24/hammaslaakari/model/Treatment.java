package Lab24.hammaslaakari.model;

import java.util.List;

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
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "treatmentid")
    private Long treatmentid;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;

    // @Column(name = "treatmentday", columnDefinition = "DATE")
    // private LocalDate treatmentDay;

    // @ManyToOne
    // @JoinColumn(name = "teeth")
    // private List<Tooth> teeth;

    // @Column(name = "toothinfo")
    // private String toothInfo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treatment")
    private List<ToothTreatment> toothTreatments;

    public Treatment() {
    }

    public Treatment(Patient patient, List<ToothTreatment> toothTreatments) {
        super();
        this.patient = patient;
        this.toothTreatments = toothTreatments;
    }

    public Long getTreatmentId() {
        return treatmentid;
    }

    // public Long getToothId(Tooth tooth) {
    // return tooth.getToothId();
    // }

    // public LocalDate getTreatmentDay() {
    // return treatmentDay;
    // }

    // public void setTreatmentDay(LocalDate treatmentDay) {
    // this.treatmentDay = treatmentDay;
    // }

    // public void setPatientId(Long patientid) {
    // this.patientid = patientid;
    // }

    public Long getPatientId() {
        return patient.getPatientId();
    }

    public List<ToothTreatment> getToothTreatments() {
        return this.toothTreatments;
    }

    // public String getToothInfo() {
    // return toothInfo;
    // }

    // public void setToothInfo(String toothInfo) {
    // this.toothInfo = toothInfo;
    // }

}
