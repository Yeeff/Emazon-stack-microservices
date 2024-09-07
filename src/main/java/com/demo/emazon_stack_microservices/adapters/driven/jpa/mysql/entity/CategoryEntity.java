package com.demo.emazon_stack_microservices.adapters.driven.jpa.mysql.entity;

import com.demo.emazon_stack_microservices.domain.util.DomainConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "name", nullable = false, length = DomainConstants.MAX_CATEGORY_NAME_LENGTH)
    private String  name;

    @Column(name = "description", nullable = false, length = DomainConstants.MAX_CATEGORY_DESCRIPTION_LENGTH)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<ArticleEntity> articles = new HashSet<>();
}
