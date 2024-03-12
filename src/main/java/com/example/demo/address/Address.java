package com.example.demo.address;

import com.example.demo.users.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue
    (
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    @Schema(example = "1", description = "Address ID")
    @Column(name = "id")
    private Long id;

    @Schema(example = "Pravda", description = "Street")
    @Column(name="street", nullable = false)
    private String street;

    @Schema(example = "60", description = "House Number")
    @Column(name="the_house", nullable = false)
    private String theHouse;

    @Schema(example = "220116", description = "Zip Code")
    @Column(name="zip_code", nullable = false)
    private String zipCode;

    // !two directional relationship!
    @OneToOne
    @JoinColumn(name="users_id")
    private Users users;

    public Address(Long id, String street, String theHouse, String zipCode) {
        this.id = id;
        this.street = street;
        this.theHouse = theHouse;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getTheHouse() {
        return theHouse;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTheHouse(String theHouse) {
        this.theHouse = theHouse;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", theHouse='" + theHouse + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
