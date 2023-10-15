package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.Models.Member;
import com.uday.MusclesDiary.Repositories.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member addMember(MemberRequestRTO memberRequestRTO) {
        Member member = new Member();
        member.setFirstName(memberRequestRTO.getFirstName());
        member.setLastName(memberRequestRTO.getLastName());
        member.setEmail(memberRequestRTO.getEmail());
        member.setPassword(memberRequestRTO.getPassword());
        return memberRepository.save(member);
    }

    @Override
    public Member login(MemberRequestRTO memberRequestRTO) {
        return new Member();
    }
}
