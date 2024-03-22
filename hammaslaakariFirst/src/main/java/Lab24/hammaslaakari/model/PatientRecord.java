package Lab24.hammaslaakari.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patientrecord")
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "patient", nullable = false)
    private AppUser patient = new AppUser();

    @Column(name = "hurtingtooth", nullable = false)
    private Tooth hurtingTooth = new Tooth();

    @Column(name = "treatmentdesc", nullable = false, updatable = true)
    private String treatmentDescription = "";

    public PatientRecord() {
    }

    public PatientRecord(AppUser patient, Tooth hurtingTooth, String treatmentDescription) {
        super();
        this.patient = patient;
        this.hurtingTooth = hurtingTooth;
        this.treatmentDescription = treatmentDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getPatient() {
        return patient;
    }

    public void setPatient(AppUser patient) {
        this.patient = patient;
    }

    public Tooth getHurtingTooth() {
        return hurtingTooth;
    }

    public void setHurtingTooth(Tooth hurtingTooth) {
        this.hurtingTooth = hurtingTooth;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

}
