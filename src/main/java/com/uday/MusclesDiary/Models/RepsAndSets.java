package com.uday.MusclesDiary.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "reps_and_sets")
public class RepsAndSets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer setCount;

    @Column(nullable = false)
    private Long reps;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long calenderId;

    @Column(nullable = false)
    private Long workoutId;

    @Column(nullable = false)
    private Long exerciseId;
}


