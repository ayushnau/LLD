package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.strategy.DriveStrategy;

public class Vehicle {
    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void run() {
        driveStrategy.drive();
    }
}