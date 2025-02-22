package com.demo.sortgeek.controller;

import com.demo.sortgeek.domain.dto.request.MemberCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.MemberUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.MemberResponseDTO;
import com.demo.sortgeek.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDTO> postMember(@Valid @RequestBody MemberCreateRequestDTO memberCreateRequestDTO) {
        MemberResponseDTO createdUser = memberService.createMember(memberCreateRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<MemberResponseDTO> getMember(){
        MemberResponseDTO member = memberService.findMemberInfo();

        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PutMapping
    public ResponseEntity<MemberResponseDTO> updateMember(@Valid @RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO) {
        System.out.println(memberUpdateRequestDTO);
        MemberResponseDTO updatedUser = memberService.updateMember(memberUpdateRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMember(){
        memberService.deleteMember();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
