package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.MemberRequestRTO;
import com.uday.MusclesDiary.Models.Member;
import com.uday.MusclesDiary.Services.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("test")
    public ResponseEntity<String> testApi(MemberRequestRTO memberRequestRTO){
        return ResponseEntity.ok("It's working");
    }
}
