package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.WorkoutCalenderRequestDTO;
import com.uday.MusclesDiary.Models.Calender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalenderService {
    Calender addWorkoutToCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO);

    Calender removeWorkoutFromCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO);
}
