package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.RepsAndSetsRequestDTO;
import com.uday.MusclesDiary.Models.RepsAndSets;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepsAndSetsService {
    List<RepsAndSets> getRepsAndSetsForWorkout(Long calenderId, Long workoutId, Long memberId);

    RepsAndSets addRepsAndSetsToExercise(RepsAndSetsRequestDTO repsAndSetsRequestDTO);
}
