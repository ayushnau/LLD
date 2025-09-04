package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.GoodsVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.HybridVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.SportsVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.Vehicle;

public class Demo {
    public static void main(String[] args) {
        System.out.println("###### Strategy Design Pattern ######");
        System.out.println("###### Example: Vehicle Drive Modes ######");

        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();

        vehicle = new GoodsVehicle();
        vehicle.drive();

        vehicle = new HybridVehicle();
        vehicle.drive();

        vehicle = new GoodsVehicle();
        vehicle.drive();
    }
}
