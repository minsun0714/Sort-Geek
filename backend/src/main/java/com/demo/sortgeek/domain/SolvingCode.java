package com.demo.sortgeek.domain;

import com.demo.sortgeek.domain.enums.LANGUAGE;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "solving_codes")
public class SolvingCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long memberId;

    @Lob
    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    private LANGUAGE language;

    @Column
    private boolean isPositiveSortingOnly;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
