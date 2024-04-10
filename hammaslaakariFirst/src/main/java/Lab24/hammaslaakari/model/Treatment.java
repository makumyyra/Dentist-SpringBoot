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
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatmentid")
    private Long treatmentId;

    @ManyToOne
    @JoinColumn(name = "toothid")
    private Tooth tooth;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;

    // @ManyToOne
    // @JoinColumn(name = "patientid")
    // private Long patientid = patient.getPatientId();

    @Column(name = "toothinfo")
    private String toothInfo;

    public Treatment() {
        super();
    }

    public Treatment(Tooth tooth, Patient patient, String toothInfo) {
        this.tooth = tooth;
        this.patient = patient;
        this.toothInfo = toothInfo;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public Long getToothId(Tooth tooth) {
        return tooth.getToothId();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getPatientId(Patient patient) {
        return patient.getPatientId();
    }

    public String getToothInfo() {
        return toothInfo;
    }

    public void setToothInfo(String toothInfo) {
        this.toothInfo = toothInfo;
    }

}
