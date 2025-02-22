package com.demo.sortgeek.security.service;

import com.demo.sortgeek.domain.Member;
import com.demo.sortgeek.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Long memberId = memberRepository.findByLoginId(loginId)
            .map(Member::getMemberId)
            .orElseThrow(() -> new IllegalArgumentException("Member not found: " + loginId));
        return memberRepository.findByLoginId(loginId)
                .map(user -> org.springframework.security.core.userdetails.User.builder()
                        .username(String.valueOf(memberId))
                        .password(user.getPassword())
                        .authorities(List.of(new SimpleGrantedAuthority(user.getRole().toString())))
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Member not found: " + loginId));
    }
}
