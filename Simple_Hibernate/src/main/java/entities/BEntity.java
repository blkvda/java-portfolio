package entities;

import javax.persistence.*;

@Entity
@Table(name = "bEntities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class BEntity {
    @Id
    @SequenceGenerator(name = "id_bEntities_generator", initialValue = 0)
    @GeneratedValue(generator = "id_bEntities_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "value", nullable = false)
    private int value;
    @Column(name = "aEntity_id", nullable = false)
    private long aEntity_id;

    public BEntity() {
    }

    public BEntity(int value, AEntity aEntity) {
        if(value < 0){
            this.value = -1;
        }
        else {
            this.value = value;
        }
        this.aEntity_id = aEntity.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getaEntity_id() {
        return aEntity_id;
    }

    public void setaEntity_id(long aEntity_id) {
        this.aEntity_id = aEntity_id;
    }

    @Override
    public String toString() {
        return "\tBEntity:" +
                "\n\t\tid = " + id +
                "\n\t\tvalue = " + value +
                "\n\t\taEntity id =" + aEntity_id +
                '\n';
    }
}
