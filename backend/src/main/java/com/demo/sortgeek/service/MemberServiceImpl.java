package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.MemberCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.MemberUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.MemberResponseDTO;
import jakarta.transaction.Transactional;

@Transactional
public class MemberServiceImpl implements MemberService{
    @Override
    public MemberResponseDTO createMember(MemberCreateRequestDTO memberRequestDTO) {
        return null;
    }

    @Override
    public MemberResponseDTO findMemberInfo() {
        return null;
    }

    @Override
    public MemberResponseDTO updateMember(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteMember() {
        return null;
    }
}
