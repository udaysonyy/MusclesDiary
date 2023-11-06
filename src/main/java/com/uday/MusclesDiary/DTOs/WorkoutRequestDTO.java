package com.uday.MusclesDiary.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkoutRequestDTO {
    private String name;
    private Long memberId;
    private List<Long> exerciseId;
    private Long workoutId;
}
