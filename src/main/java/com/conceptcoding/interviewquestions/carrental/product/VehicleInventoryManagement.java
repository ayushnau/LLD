package com.conceptcoding.interviewquestions.carrental.product;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {

    List<Vehicle> vehicles;

    public VehicleInventoryManagement() {
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles; // filtering
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateVehicleStatus(int vehicleId, VehicleStatus vehicleStatus) {
        vehicles.stream().filter(vehicle -> vehicle.getVehicleID() == vehicleId).findFirst()
                .ifPresent(vehicle -> vehicle.setStatus(vehicleStatus));
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicles.stream().filter(v -> v.getVehicleID() == vehicle.getVehicleID()).findFirst()
                .ifPresent(v -> v.setKmDriven(vehicle.getKmDriven()));
    }
}