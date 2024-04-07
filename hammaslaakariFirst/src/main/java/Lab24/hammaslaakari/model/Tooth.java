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
    @Column(name = "toothid", nullable = false, updatable = false)
    private Long toothId;

    @Column(name = "toothname", nullable = false, unique = true)
    private String toothname;

    public Tooth() {
        super();
    }

    public Tooth(String toothname, String toothInfo) {
        super();
        this.toothname = toothname;
    }

    public Long getToothId() {
        return toothId;
    }

    public void setToothId(Long toothId) {
        this.toothId = toothId;
    }

    public String getToothname() {
        return toothname;
    }

    public void setToothname(String toothname) {
        this.toothname = toothname;
    }

}
