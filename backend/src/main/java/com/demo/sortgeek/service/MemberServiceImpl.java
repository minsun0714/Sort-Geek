package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.Member;
import com.demo.sortgeek.domain.dto.request.MemberCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.MemberUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.MemberResponseDTO;
import com.demo.sortgeek.domain.enums.ROLE;
import com.demo.sortgeek.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

import static com.demo.sortgeek.DTOmapper.memberMapper.toMemberResponseDTO;
import static com.demo.sortgeek.security.utils.SecurityUtil.getAuthenticatedMemberId;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberResponseDTO createMember(MemberCreateRequestDTO memberCreateRequestDTO) {
        Member member = Member.builder()
                .loginId(memberCreateRequestDTO.getLoginId())
                .password(passwordEncoder.encode(memberCreateRequestDTO.getPassword()))
                .role(ROLE.ADMIN)
                .build();

        if (!Objects.equals(memberCreateRequestDTO.getPassword(), memberCreateRequestDTO.getPasswordConfirm())){
            throw new IllegalArgumentException("Passwords do not match");
        }

        Member savedMember = memberRepository.save(member);

        return toMemberResponseDTO(savedMember);
    }

    @Override
    public MemberResponseDTO findMemberInfo() {
        Long memberId = getAuthenticatedMemberId();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return toMemberResponseDTO(member);
    }

    @Override
    @Transactional
    public MemberResponseDTO updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        Long memberId = getAuthenticatedMemberId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        if (memberUpdateRequestDTO.getPassword() != null) {
            member.setPassword(passwordEncoder.encode(memberUpdateRequestDTO.getPassword()));
        }

        return toMemberResponseDTO(member);
    }

    @Override
    @Transactional
    public void deleteMember() {
        Long memberId = getAuthenticatedMemberId();
        if (!memberRepository.existsById(memberId)) {
            throw new IllegalArgumentException("User not found");
        }
        memberRepository.deleteById(memberId);
    }
}
