package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.WorkoutRequestDTO;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Workout;
import com.uday.MusclesDiary.Services.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/add-workout")
    public ResponseEntity<Workout> addWorkout(@RequestBody WorkoutRequestDTO workoutRequestDTO){
        Workout workout = workoutService.addWorkout(workoutRequestDTO);
        return ResponseEntity.ok(workout);
    }

    @GetMapping("/get-workouts/{memberId}")
    public ResponseEntity<List<Workout>> getWorkout(@PathVariable(value = "memberId") Long id){
        List<Workout> workoutList = workoutService.getWorkout(id);
        return ResponseEntity.ok(workoutList);
    }
}
