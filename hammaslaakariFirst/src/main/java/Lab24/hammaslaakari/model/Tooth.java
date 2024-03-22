package Lab24.hammaslaakari.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tooth")
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "toothname", nullable = false, unique = true)
     */
    @Column(name = "toothname", nullable = false, unique = true)
    private String toothname;

    @Column(name = "treatedbefore", nullable = false)
    private boolean treatedBefore;

    public Tooth() {
        super();
    }

    public Tooth(String toothname, boolean treatedBefore) {
        super();
        this.toothname = toothname;
        this.treatedBefore = treatedBefore;
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

}
