package org.example.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport() {}

    public Passport(Person person, int passportNumber) {
        this.person = person;
        this.passportNumber = passportNumber;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
    public int getPassportNumber() {
        return passportNumber;
    }

    public String toString() {
        return "Passport{" +
                "person="+ person +
                ", passportNumber=" + passportNumber + "}";
    }

}
