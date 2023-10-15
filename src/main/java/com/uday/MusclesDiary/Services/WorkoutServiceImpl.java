package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.WorkoutRequestDTO;
import com.uday.MusclesDiary.Exception.ExerciseNotFoundException;
import com.uday.MusclesDiary.Exception.MemberNotFoundException;
import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Member;
import com.uday.MusclesDiary.Models.Workout;
import com.uday.MusclesDiary.Repositories.ExerciseRepository;
import com.uday.MusclesDiary.Repositories.MemberRepository;
import com.uday.MusclesDiary.Repositories.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.uday.MusclesDiary.Common.Constant.EXERCISE_NOT_FOUND;
import static com.uday.MusclesDiary.Common.Constant.MEMBER_NOT_FOUND;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;
    private final MemberRepository memberRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository,
                              MemberRepository memberRepository,
                              ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.memberRepository = memberRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Workout addWorkout(WorkoutRequestDTO workoutRequestDTO) {
        Workout workout = new Workout();
        workout.setName(workoutRequestDTO.getName());
        setMemberToWorkout(workoutRequestDTO.getMemberId(), workout);
        setExerciseToWorkout(workoutRequestDTO.getExerciseId(), workout);
        return workoutRepository.save(workout);
    }

    @Override
    public List<Workout> getWorkout(Long id) {
        return workoutRepository.getExercise(id);
    }

    private void setExerciseToWorkout(List<Long> exerciseId, Workout workout) {
        List<Exercise> exerciseList = new ArrayList<>();
        for(Long id : exerciseId) {
            Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(EXERCISE_NOT_FOUND));
            exerciseList.add(exercise);
        }
        workout.setExercises(exerciseList);
    }

    private void setMemberToWorkout(Long memberId, Workout workout) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(MEMBER_NOT_FOUND));
        workout.setMember(member);
    }
}
