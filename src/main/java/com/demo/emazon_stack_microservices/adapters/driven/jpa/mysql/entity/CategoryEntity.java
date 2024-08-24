package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "category",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "UK_category_name")})
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String  name;

    @Column(name = "description", nullable = false, length = 90)
    private String description;
}
