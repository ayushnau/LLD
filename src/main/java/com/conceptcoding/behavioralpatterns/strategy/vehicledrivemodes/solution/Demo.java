package com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution;

import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.GoodsVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.HybridVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.SportsVehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.context.Vehicle;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.EVDrive;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.NormalDrive;
import com.conceptcoding.behavioralpatterns.strategy.vehicledrivemodes.solution.strategies.SportsDrive;

public class Demo {
    public static void main(String[] args) {
        System.out.println("###### Strategy Design Pattern ######");
        System.out.println("###### Example: Vehicle Drive Modes ######");

        Vehicle vehicle = new SportsVehicle(new SportsDrive());
        vehicle.drive();

        vehicle = new GoodsVehicle(new NormalDrive());
        vehicle.drive();

        vehicle = new HybridVehicle(new EVDrive());
        vehicle.drive();

        vehicle = new GoodsVehicle(new NormalDrive());
        vehicle.drive();
    }
}



// 1. here Concrete Strategy are evdrive, normaldrive, sportsdrive 
// 2. interface is driveStrategy
// 3. context is goodsvehicle, hybridvehicle whose parent is vehicle. 
// 4. client is demo.java which is invoking the strategy pattern while creating the constsructor
// which means that once the object crated it will always use that. only. which is fixed strategy switching.