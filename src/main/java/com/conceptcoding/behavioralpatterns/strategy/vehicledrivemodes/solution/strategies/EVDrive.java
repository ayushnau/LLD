package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies;

// Concrete strategy for electric drive mode
public class EVDrive implements DriveStrategy {

    // A new strategy for driving in snow conditions
    @Override
    public void drive() {
        System.out.println("Driving Capability: Electric");
    }
}
