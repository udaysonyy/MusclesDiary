package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.Models.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    Member addMember(MemberRequestRTO memberRequestRTO);

    Member login(MemberRequestRTO memberRequestRTO);
}
