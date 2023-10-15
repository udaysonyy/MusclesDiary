package com.uday.MusclesDiary.Controllers;

import com.uday.MusclesDiary.DTOs.WorkoutCalenderRequestDTO;
import com.uday.MusclesDiary.Models.Calender;
import com.uday.MusclesDiary.Services.CalenderServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calender")
public class CalenderController {

    private final CalenderServiceImpl calenderService;

    public CalenderController(CalenderServiceImpl calenderService) {
        this.calenderService = calenderService;
    }

    @PostMapping("add-calender")
    private Calender addWorkoutToCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO){
        return calenderService.addWorkoutToCalender(workoutCalenderRequestDTO);
    }

    @PostMapping("remove-calender")
    private Calender removeWorkoutFromCalender(WorkoutCalenderRequestDTO workoutCalenderRequestDTO){
        return calenderService.removeWorkoutFromCalender(workoutCalenderRequestDTO);
    }
}
