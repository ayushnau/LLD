package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.strategy.DriveStrategy;

public class Buggati extends Vehicle {
    public Buggati(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}