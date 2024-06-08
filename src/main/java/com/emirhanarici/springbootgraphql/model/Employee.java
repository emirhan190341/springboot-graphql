package com.emirhanarici.springbootgraphql.model;


import com.emirhanarici.springbootgraphql.model.enums.Department;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {

    private String name;
    private String surname;
    private String identityNumber;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id",nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Contact> contacts;


}
