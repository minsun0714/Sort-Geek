package com.demo.sortgeek.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sort_types")
public class SortType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long sortTypeId;

    @Column(nullable = false)
    private String sortType;

    @Column
    private Boolean isPositiveOnly;

    @OneToMany(mappedBy = "sortType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegisteredCode> registeredCode = new ArrayList<>();
}
