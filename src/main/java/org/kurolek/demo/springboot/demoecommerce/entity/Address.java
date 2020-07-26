package org.kurolek.demo.springboot.demoecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @Column(name = "street", nullable = false, length = 50)
    private String street;

}