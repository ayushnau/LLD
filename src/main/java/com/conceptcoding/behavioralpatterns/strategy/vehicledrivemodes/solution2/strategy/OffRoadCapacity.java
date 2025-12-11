package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.strategy;

public class OffRoadCapacity implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving Capability: Off Road");
    }
}