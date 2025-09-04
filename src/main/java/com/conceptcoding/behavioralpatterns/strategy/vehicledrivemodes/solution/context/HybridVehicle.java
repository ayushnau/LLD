package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.EVDrive;

// Concrete context subclass
public class HybridVehicle extends Vehicle {

    public HybridVehicle() {
        // Hybrid vehicle can drive in electric mode
        super(new EVDrive()); // additional capability
    }
}
