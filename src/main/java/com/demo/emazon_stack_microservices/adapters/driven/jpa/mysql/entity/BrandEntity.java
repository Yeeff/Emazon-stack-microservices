package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity;

import com.demo.emazon_stack_microservices.domain.util.DomainConstants;
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
@Table(name = "brand",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "UK_brand_name")})
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = DomainConstants.MAX_BRAND_NAME_LENGTH)
    private String  name;

    @Column(name = "description", nullable = false, length = DomainConstants.MAX_BRAND_DESCRIPTION_LENGTH)
    private String description;
}
