package Lab24.hammaslaakari.model;

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
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientid") // , nullable = false, updatable = false)
    private Long patientId;

    @JoinColumn(name = "patientname", nullable = false)
    private String username;

    // @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    // private List<Tooth> patientDentalMap;

    public Patient() {
        super();
    }

    public Patient(String username) {
        this.username = username;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
