package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.ExerciseRequestDTO;
import com.uday.MusclesDiary.DTOs.WorkoutRequestDTO;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Workout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseService {
    Exercise addExercise(ExerciseRequestDTO exerciseRequestDTO);

    List<Exercise> getExercises(Long memberId);
}
