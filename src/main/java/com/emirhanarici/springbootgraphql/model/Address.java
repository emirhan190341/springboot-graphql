package com.emirhanarici.springbootgraphql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private String street;
    private String zipCode;

    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Employee employee;
}
