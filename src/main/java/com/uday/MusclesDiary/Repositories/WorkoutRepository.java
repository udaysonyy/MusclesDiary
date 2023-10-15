package com.uday.MusclesDiary.Repositories;

import com.uday.MusclesDiary.Models.Exercise;
import com.uday.MusclesDiary.Models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query("SELECT w FROM workout w WHERE w.member.id = :memberId")
    List<Workout> getExercise(Long memberId);
}
