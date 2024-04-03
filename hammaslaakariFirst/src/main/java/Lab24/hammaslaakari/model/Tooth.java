package Lab24.hammaslaakari.model;

import java.io.Serializable;
import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tooth")
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "toothname", nullable = false, unique = true)
    private String toothname;

    @Column(name = "treatedbefore", nullable = false)
    private boolean treatedBefore;

    @Column(name = "toothinfo")
    private String toothInfo;

    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;

    public Tooth() {
        super();
    }

    public Tooth(String toothname, boolean treatedBefore, String toothInfo) {
        super();
        this.toothname = toothname;
        this.treatedBefore = treatedBefore;
        this.toothInfo = toothInfo;
    }

    public String getToothname() {
        return toothname;
    }

    public void setToothname(String toothname) {
        this.toothname = toothname;
    }

    public boolean isTreatedBefore() {
        return treatedBefore;
    }

    public void setTreatedBefore(boolean treatedBefore) {
        this.treatedBefore = treatedBefore;
    }

    public String getToothInfo() {
        return toothInfo;
    }

    public void setToothInfo(String toothInfo) {
        this.toothInfo = toothInfo;
    }

}
