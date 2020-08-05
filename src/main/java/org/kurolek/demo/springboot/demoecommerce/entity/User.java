package org.kurolek.demo.springboot.demoecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 25)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
