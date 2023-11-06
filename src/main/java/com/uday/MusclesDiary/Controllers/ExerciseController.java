package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.ExerciseRequestDTO;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Workout;
import com.uday.MusclesDiary.Services.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/add-exercise")
    public ResponseEntity<Exercise> addWorkout(@RequestBody ExerciseRequestDTO exerciseRequestDTO){
        Exercise exercise = exerciseService.addExercise(exerciseRequestDTO);
        return ResponseEntity.ok(exercise);
    }

    @GetMapping("/get-exercises/{memberId}")
    public ResponseEntity<List<Exercise>> addWorkout(@PathVariable(value = "memberId") Long memberId){
        List<Exercise> exercises = exerciseService.getExercises(memberId);
        return ResponseEntity.ok(exercises);
    }
}
