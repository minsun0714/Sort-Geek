package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.MemberCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.MemberUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.MemberResponseDTO;

public interface MemberService {
    MemberResponseDTO createMember(MemberCreateRequestDTO memberRequestDTO);

    MemberResponseDTO findMemberInfo();

    MemberResponseDTO updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO);

    void deleteMember();
}
