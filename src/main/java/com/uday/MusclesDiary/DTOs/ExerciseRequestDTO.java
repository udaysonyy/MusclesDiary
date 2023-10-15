package com.uday.MusclesDiary.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExerciseRequestDTO {
    private String name;
    private String targetMuscle;
    private Long memberId;
    private List<Long> workoutId;
}
