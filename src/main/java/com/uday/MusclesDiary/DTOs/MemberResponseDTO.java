package com.uday.MusclesDiary.DTOs;

import com.uday.MusclesDiary.Models.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDTO {
    private Member member;
    private String token;
}
