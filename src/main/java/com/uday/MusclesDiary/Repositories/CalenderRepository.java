package com.uday.MusclesDiary.Repositories;

import com.uday.MusclesDiary.Models.Calender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CalenderRepository extends JpaRepository<Calender, Long> {

    @Query(value = "SELECT c FROM Calender c WHERE c.date = :date")
    Optional<Calender> findByDate(LocalDate date);
}
