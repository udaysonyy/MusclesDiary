package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.RepsAndSetsRequestDTO;
import com.uday.MusclesDiary.Models.RepsAndSets;
import com.uday.MusclesDiary.Services.RepsAndSetsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepsAndSetsController {

    private RepsAndSetsServiceImpl repsAndSetsService;

    @GetMapping("/get-reps-and-sets/{memberId}/calender/{calenderId}/workout/{workoutId}")
    public ResponseEntity<List<RepsAndSets>> getWorkout(@PathVariable(value = "memberId") Long memberId,
                                                    @PathVariable(value = "calenderId") Long calenderId,
                                                    @PathVariable(value = "workoutId") Long workoutId){
        List<RepsAndSets> repsAndSetsList = repsAndSetsService.getRepsAndSetsForWorkout(calenderId, workoutId, memberId);
        return ResponseEntity.ok(repsAndSetsList);
    }

    @PostMapping("/add-sets-and-reps")
    public ResponseEntity<RepsAndSets> addRepsAndSetsToExercise(@RequestBody RepsAndSetsRequestDTO repsAndSetsRequestDTO){
        RepsAndSets repsAndSets = repsAndSetsService.addRepsAndSetsToExercise(repsAndSetsRequestDTO);
        return ResponseEntity.ok(repsAndSets);
    }
}
