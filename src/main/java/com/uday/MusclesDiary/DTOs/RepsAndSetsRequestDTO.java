package com.uday.MusclesDiary.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepsAndSetsRequestDTO {
    private Long exerciseId;
    private Long workoutId;
    private Long memberId;
    private Long calendarId;
    private Long reps;
    private Integer setCount;
}
