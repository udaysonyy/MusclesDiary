package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.DTOs.MemberResponseDTO;
import com.uday.MusclesDiary.Exception.MemberNotFoundException;
import com.uday.MusclesDiary.Models.Member;
import com.uday.MusclesDiary.Models.Role;
import com.uday.MusclesDiary.Repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public MemberResponseDTO addMember(MemberRequestRTO memberRequestRTO) {
        Member member = new Member();
        member.setFirstName(memberRequestRTO.getFirstName());
        member.setLastName(memberRequestRTO.getLastName());
        member.setEmail(memberRequestRTO.getEmail());
        member.setPassword(passwordEncoder.encode(memberRequestRTO.getPassword()));
        member.setRole(memberRequestRTO.getRole().equals("USER") ? Role.USER : Role.ADMIN);
        Member savedMember = memberRepository.save(member);

        String token = jwtService.generateToken(member);

        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setMember(savedMember);
        memberResponseDTO.setToken(token);
        return memberResponseDTO;
    }

    @Override
    public MemberResponseDTO login(MemberRequestRTO memberRequestRTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        memberRequestRTO.getEmail(),
                        memberRequestRTO.getPassword()
                )
        );

        Member member = memberRepository
                .findByEmail(memberRequestRTO.getEmail())
                .orElseThrow(() -> new MemberNotFoundException("Member Not Found."));
        String token = jwtService.generateToken(member);

        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        memberResponseDTO.setMember(member);
        memberResponseDTO.setToken(token);
        return memberResponseDTO;
    }
}
