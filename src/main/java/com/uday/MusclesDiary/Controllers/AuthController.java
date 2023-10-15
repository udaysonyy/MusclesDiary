package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.DTOs.MemberResponseDTO;
import com.uday.MusclesDiary.Services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponseDTO> registerNewMember(@Valid @RequestBody MemberRequestRTO memberRequestRTO){
        MemberResponseDTO member = authService.addMember(memberRequestRTO);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDTO> login(@Valid @RequestBody MemberRequestRTO memberRequestRTO){
        MemberResponseDTO member = authService.login(memberRequestRTO);
        return ResponseEntity.ok(member);
    }
}
