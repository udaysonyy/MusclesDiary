package com.uday.MusclesDiary.Repositories;

import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT e FROM exercise e WHERE e.memberId = :memberId")
    List<Exercise> getExercise(Long memberId);
}
