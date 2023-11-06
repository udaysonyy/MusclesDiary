package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.RepsAndSetsRequestDTO;
import com.uday.MusclesDiary.Models.Calender;
import com.uday.MusclesDiary.Models.RepsAndSets;
import com.uday.MusclesDiary.Repositories.CalenderRepository;
import com.uday.MusclesDiary.Repositories.RepsAndSetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepsAndSetsServiceImpl implements RepsAndSetsService{

    private final RepsAndSetsRepository repsAndSetsRepository;
    private final CalenderRepository calenderRepository;

    @Override
    public List<RepsAndSets> getRepsAndSetsForWorkout(Long calenderId, Long workoutId, Long memberId) {
        return repsAndSetsRepository.getRepsAndSetForCalenderWorkout(memberId, workoutId, calenderId);
    }

    @Override
    public RepsAndSets addRepsAndSetsToExercise(RepsAndSetsRequestDTO repsAndSetsRequestDTO) {
        RepsAndSets repsAndSets = new RepsAndSets();
        repsAndSets.setExerciseId(repsAndSetsRequestDTO.getExerciseId());
        repsAndSets.setSetCount(repsAndSetsRequestDTO.getSetCount());
        repsAndSets.setReps(repsAndSetsRequestDTO.getReps());
        repsAndSets.setWorkoutId(repsAndSetsRequestDTO.getWorkoutId());
        repsAndSets.setMemberId(repsAndSetsRequestDTO.getMemberId());
        repsAndSets.setCalenderId(repsAndSetsRequestDTO.getCalendarId());
        return repsAndSetsRepository.save(repsAndSets);
    }
}
