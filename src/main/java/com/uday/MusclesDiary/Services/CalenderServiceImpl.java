package com.uday.MusclesDiary.Services;

import com.uday.MusclesDiary.DTOs.WorkoutCalenderRequestDTO;
import com.uday.MusclesDiary.Exception.CalenderNotFoundException;
import com.uday.MusclesDiary.Models.Calender;
import com.uday.MusclesDiary.Models.Workout;
import com.uday.MusclesDiary.Repositories.CalenderRepository;
import com.uday.MusclesDiary.Repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalenderServiceImpl implements CalenderService {

    private final WorkoutRepository workoutRepository;
    private final CalenderRepository calenderRepository;

    @Override
    public Calender addWorkoutToCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO) {
        Optional<Calender> calenderOptional = calenderRepository.findByDate(workoutCalenderRequestDTO.getDate());
        Calender calender = calenderOptional.isEmpty() ? new Calender() : calenderOptional.get();
        List<Workout> workoutList = workoutRepository.findAllById(workoutCalenderRequestDTO.getWorkoutId());
        calender.setWorkout(workoutList);
        calender.setDate(workoutCalenderRequestDTO.getDate());
        return calenderRepository.save(calender);
    }

    @Override
    public Calender removeWorkoutFromCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO) {
        Optional<Calender> calenderOptional = calenderRepository.findByDate(workoutCalenderRequestDTO.getDate());
        if(calenderOptional.isEmpty()) {
            throw new CalenderNotFoundException("Calender not found by date.");
        }

        Calender calender = calenderOptional.get();
        List<Workout> workoutList = calender.getWorkout().stream().filter(workout -> !(workoutCalenderRequestDTO.getWorkoutId().contains(workout.getId()))).collect(Collectors.toList());
        calender.setWorkout(workoutList);
        return calenderRepository.save(calender);
    }

    @Override
    public Calender getWorkoutByDate(LocalDate date) {
        Optional<Calender> calenderOptional = calenderRepository.findByDate(date);
        if(calenderOptional.isEmpty()) {
            return null;
        }
        return calenderOptional.get();
    }
}
