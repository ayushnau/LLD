package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.NormalDrive;

// Concrete context subclass
public class GoodsVehicle extends Vehicle {

    public GoodsVehicle() {
        super(new NormalDrive());
    }
}
