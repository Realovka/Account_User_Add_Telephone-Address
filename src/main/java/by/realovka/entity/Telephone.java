package by.realovka.entity;

import javax.persistence.*;


@Entity
@Table (name = "telephones")
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private String category;

    public Telephone(long id, String number, String category) {
        this.id = id;
        this.number = number;
        this.category = category;
    }

    public Telephone(String number, String category) {
        this.number = number;
        this.category = category;
    }

    public Telephone(String number) {
        this.number = number;
    }

    public Telephone() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
