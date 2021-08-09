package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aEntities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class AEntity {
    @Id
    @SequenceGenerator(name = "id_aEntities_generator", initialValue = 0)
    @GeneratedValue(generator = "id_aEntities_generator")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(fetch = FetchType.EAGER, targetEntity=BEntity.class, cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private List<BEntity> bEntitiesList;

    public AEntity() {
        this("default-empty");
    }

    public AEntity(String description) {
        if(description.length() == 0 || description.equals("")){
            this.description = "default-empty";
        }
        else{
            this.description = description;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BEntity> getbEntitiesList() {
        return bEntitiesList;
    }

    public void setbEntitiesList(List<BEntity> bEntitiesList) {
        this.bEntitiesList = bEntitiesList;
    }

    @Override
    public String toString() {
        return "AEntity:" +
                "\n\tid = " + id +
                "\n\tdescription = " + description + '\'' +
                "\n\tbEntitiesList = " + bEntitiesList +
                "\n";
    }
}
