package org.kurolek.demo.springboot.demoecommerce.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
}
