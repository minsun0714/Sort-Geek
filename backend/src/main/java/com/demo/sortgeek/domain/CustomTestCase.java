package com.demo.sortgeek.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "custom_test_cases")

public class CustomTestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long testCaseId;

    @Column(columnDefinition = "TEXT")
    private String testInputJson;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setTestInput(List<Long> testInput) {
        try {
            this.testInputJson = new ObjectMapper().writeValueAsString(testInput);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 변환 중 오류 발생", e);
        }
    }

    public List<Long> getTestInput() {
        try {
            return new ObjectMapper().readValue(this.testInputJson, new TypeReference<List<Long>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 파싱 중 오류 발생", e);
        }
    }

}
