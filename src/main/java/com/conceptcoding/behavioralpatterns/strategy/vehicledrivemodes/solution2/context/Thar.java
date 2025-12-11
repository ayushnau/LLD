package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution2.strategy.DriveStrategy;

public class Thar extends Vehicle {
    public Thar(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}