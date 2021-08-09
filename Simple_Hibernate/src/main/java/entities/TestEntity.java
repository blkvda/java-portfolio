package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntity {
    @Id
    @GeneratedValue
    @Column(name = "idEntity")
    private int id;
    @Column(name = "priceEntity")
    private int price;

    public TestEntity(int price) {
        this.price = price;
    }

    public TestEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idEntity) {
        this.id = idEntity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TestEntity:" +
                "\nid: " + id +
                "\nprice=" + price + "\n";
    }
}
