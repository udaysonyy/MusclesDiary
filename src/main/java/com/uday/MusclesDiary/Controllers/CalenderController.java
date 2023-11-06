package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.WorkoutCalenderRequestDTO;
import com.uday.MusclesDiary.Models.Calender;
import com.uday.MusclesDiary.Services.CalenderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calender")
public class CalenderController {

    private final CalenderServiceImpl calenderService;

    public CalenderController(CalenderServiceImpl calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping("add-calender")
    private Calender addWorkoutToCalender(@RequestBody WorkoutCalenderRequestDTO workoutCalenderRequestDTO){
        return calenderService.addWorkoutToCalender(workoutCalenderRequestDTO);
    }

    @PostMapping("remove-calender")
    private Calender removeWorkoutFromCalender(@RequestBody WorkoutCalenderRequestDTO workoutCalenderRequestDTO){
        return calenderService.removeWorkoutFromCalender(workoutCalenderRequestDTO);
    }

    @GetMapping("get-calender-workout")
    private Calender getWorkoutByDate(@RequestParam(name = "date") LocalDate date){
        return calenderService.getWorkoutByDate(date);
    }
}
