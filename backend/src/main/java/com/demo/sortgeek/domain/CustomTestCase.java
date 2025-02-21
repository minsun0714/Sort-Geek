package com.demo.sortgeek.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "custom_test_cases")
public class CustomTestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long testCaseId;

    @Column
    private String testInput;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
