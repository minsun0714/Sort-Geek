package com.demo.sortgeek.domain;

import com.demo.sortgeek.domain.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "registered_codes")
public class RegisteredCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long codeId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Lob
    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    @Column
    private LANGUAGE language;

    @ManyToOne
    @JoinColumn(name = "sort_type_id")
    private SortType sortType;

    @Enumerated(EnumType.STRING)
    @Column
    private STATUS status;

    @Column
    private Long likeCount; // 트리거 이용 필요

    @Column
    private Long dislikeCount; // 트리거 이용 필요

    @Column
    private Long commentCount; // 트리거 이용 필요

    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "registeredCode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
