package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.ExerciseRequestDTO;
import com.uday.MusclesDiary.Exception.ExerciseNotFoundException;
import com.uday.MusclesDiary.Exception.MemberNotFoundException;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Member;
import com.uday.MusclesDiary.Models.Workout;
import com.uday.MusclesDiary.Repositories.ExerciseRepository;
import com.uday.MusclesDiary.Repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.uday.MusclesDiary.Common.Constant.EXERCISE_NOT_FOUND;
import static com.uday.MusclesDiary.Common.Constant.MEMBER_NOT_FOUND;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;
    private final MemberRepository memberRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, MemberRepository memberRepository) {
        this.exerciseRepository = exerciseRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public Exercise addExercise(ExerciseRequestDTO exerciseRequestDTO) {
        Exercise exercise = new Exercise();
        exercise.setName(exerciseRequestDTO.getName());
        exercise.setTargetMuscle(exerciseRequestDTO.getTargetMuscle());
        exercise.setMemberId(exerciseRequestDTO.getMemberId());
        return exerciseRepository.save(exercise);
    }

    @Override
    public List<Exercise> getExercises(Long id) {
        return exerciseRepository.getExercise(id);
    }

//    private void setWorkoutToExercise(List<Long> workoutId, Exercise exercise) {
//        List<Exercise> exerciseList = new ArrayList<>();
//        for(Long id : exerciseId) {
//            Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(EXERCISE_NOT_FOUND));
//            exerciseList.add(exercise);
//        }
//        exercise.set(exerciseList);
//    }
//
//    private void setMemberToExercise(Long memberId, Workout workout) {
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
//        workout.setMember(member);
//    }
}
