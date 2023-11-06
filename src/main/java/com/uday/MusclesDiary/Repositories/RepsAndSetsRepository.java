package com.uday.MusclesDiary.Repositories;

import com.uday.MusclesDiary.Models.RepsAndSets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepsAndSetsRepository extends JpaRepository<RepsAndSets, Long> {

    @Query("SELECT reps FROM reps_and_sets reps WHERE reps.workoutId = :workoutId " +
            "AND reps.memberId = :memberId AND reps.calenderId = :calenderId")
    List<RepsAndSets> getRepsAndSetForCalenderWorkout(Long memberId, Long workoutId, Long calenderId);
}
