package com.workintech.S18D4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "adress", schema = "spring")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int id;
    @Column(name = "street")
    private String street;
    @Column(name = "no")
    private int no;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH }, mappedBy = "adress")
    private Customer customer;

    public void setId(int id) {
        this.id = id;
    }
}
