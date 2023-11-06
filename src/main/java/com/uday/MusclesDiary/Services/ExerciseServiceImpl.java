package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.ExerciseRequestDTO;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Repositories.ExerciseRepository;
import com.uday.MusclesDiary.Repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Exercise> getExercises(Long memberId) {
        return exerciseRepository.getExercise(memberId);
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
