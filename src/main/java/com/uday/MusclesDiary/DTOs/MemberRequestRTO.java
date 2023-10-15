package com.uday.MusclesDiary.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestRTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;
}
