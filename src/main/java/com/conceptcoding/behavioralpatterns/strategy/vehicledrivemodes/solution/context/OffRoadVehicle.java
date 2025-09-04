package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.SportsDrive;

// Concrete context subclass
public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new SportsDrive());
    }
}
