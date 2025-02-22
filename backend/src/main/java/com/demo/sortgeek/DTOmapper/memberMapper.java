package com.demo.sortgeek.DTOmapper;

import com.demo.sortgeek.domain.Member;
import com.demo.sortgeek.domain.dto.response.MemberResponseDTO;

public class memberMapper {
    public static MemberResponseDTO toMemberResponseDTO(Member member){


        return MemberResponseDTO.builder()
                .loginId(member.getLoginId())
                .profileImg(member.getProfileImg())
                .role(member.getRole())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .build();
    }
}
