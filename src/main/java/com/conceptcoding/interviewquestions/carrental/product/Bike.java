package com.conceptcoding.interviewquestions.carrental.product;

import java.util.Date;

public class Bike extends Vehicle {

    public Bike(int vehicleID, int cc, int noOfSeat, String modelName, String companyName, int kmDriven, int average, double dailyRentalCost, double hourlyRentalCost,
                Date manufacturingDate) {
        this.vehicleID = vehicleID;
        this.cc = cc;
        this.noOfSeat = noOfSeat;
        this.modelName = modelName;
        this.companyName = companyName;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
        this.vehicleType = VehicleType.MOTORCYCLE;
        this.kmDriven = kmDriven;
        this.average = average;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.manufacturingDate = manufacturingDate;
    }
}
