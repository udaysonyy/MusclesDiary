package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.DTOs.MemberResponseDTO;
import com.uday.MusclesDiary.Models.Member;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    MemberResponseDTO addMember(MemberRequestRTO memberRequestRTO);

    MemberResponseDTO login(MemberRequestRTO memberRequestRTO);
}
