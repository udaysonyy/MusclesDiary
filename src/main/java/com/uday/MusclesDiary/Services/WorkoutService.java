package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.WorkoutRequestDTO;
import com.uday.MusclesDiary.Models.Workout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkoutService {

    Workout addWorkout(WorkoutRequestDTO workoutRequestDTO);

    List<Workout> getWorkout(Long id);
}
