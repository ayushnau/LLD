package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.SportsDrive;

// Concrete context subclass
public class SportsVehicle extends Vehicle {

    public SportsVehicle() {
        super(new SportsDrive());
    }
}
