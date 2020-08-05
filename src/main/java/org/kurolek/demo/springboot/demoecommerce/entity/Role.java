package org.kurolek.demo.springboot.demoecommerce.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "Roles")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 25)
    private String name;
}
