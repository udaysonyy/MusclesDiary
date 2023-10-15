package com.uday.MusclesDiary.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class WorkoutCalenderRequestDTO {
    private LocalDate date;
    private List<Long> workoutId;
}
