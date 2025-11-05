package com.conceptcoding.interviewquestions.carrental;

import com.conceptcoding.interviewquestions.carrental.payment.PaymentMode;
import com.conceptcoding.interviewquestions.carrental.product.Bike;
import com.conceptcoding.interviewquestions.carrental.product.Car;
import com.conceptcoding.interviewquestions.carrental.product.Vehicle;
import com.conceptcoding.interviewquestions.carrental.product.VehicleType;
import com.conceptcoding.interviewquestions.carrental.reservation.Reservation;
import com.conceptcoding.interviewquestions.carrental.reservation.ReservationStatus;
import com.conceptcoding.interviewquestions.carrental.reservation.ReservationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        System.out.println("\nLLD: Simulating a Car Rental System...");

        // Set up a car rental store - add users and vehicles in a store
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        // 0. User comes
        User user = users.getFirst();

        // 1. User selects the store
        Store store = rentalSystem.getStore(1081);

        // 2. User selects the vehicle
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.FOUR_WHEELER);

        // 3. User books the vehicle
        LocalDate fromDate = LocalDate.of(2025, 04, 19);
        LocalDate toDate = LocalDate.of(2025, 04, 22);
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0), fromDate, toDate, ReservationType.DAILY);

        // 4. User starts the trip
        store.updateReservation(reservation, ReservationStatus.IN_USE);

        // 5. User submits the vehicle
        store.submitVehicle(reservation.getReservationId());

        // 6. System accepts the vehicle and generates the invoice
        Bill bill = store.generateBill(reservation.getReservationId());

        // 7. User makes the Payment for the bill
        store.makePayment(bill, PaymentMode.CASH);

    }

    public static List<Vehicle> addVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car(101, 1200, 5, "Fortuner ", "Toyota", 10000, 12, 1200, 1200, new Date());
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.FOUR_WHEELER);

        Vehicle vehicle2 = new Car(102, 1500, 5, "Nexon ", "TATA", 10000, 12, 1200, 1200, new Date());
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.FOUR_WHEELER);

        Vehicle vehicle3 = new Bike(303, 900, 2, "Activa", "Honda", 5900, 12, 1200, 1200, new Date());
        vehicle1.setVehicleID(3);
        vehicle1.setVehicleType(VehicleType.MOTORCYCLE);
        vehicles.add(vehicle3);

        Vehicle vehicle4 = new Bike(404, 1200, 2, "Gen3", "Ola", 3500, 12, 1200, 1200, new Date());
        vehicle1.setVehicleID(4);
        vehicle1.setVehicleType(VehicleType.MOTORCYCLE);
        vehicles.add(vehicle4);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);

        return vehicles;
    }

    public static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User(801, "John", "DL2022GDG556690");
        User user2 = new User(802, "Antony", "DL2017DHW9090765231");
        users.add(user1);
        users.add(user2);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();

        // Store 1: Malleshwaram Bangalore
        Location location1 = new Location(43012, "Gandhinagar", "Bangalore", "Karnataka", "India", 403012);
        Store store1 = new Store(1081, location1);
        store1.setVehicles(vehicles);

        // Store 2: Koramangala Bangalore
        Location location2 = new Location(44412, "Koramangala", "Bangalore", "Karnataka", "India", 403012);
        Store store2 = new Store(1082, location2);
        store2.setVehicles(vehicles);

        // Add stores to the system
        stores.add(store1);
        stores.add(store2);

        return stores;
    }
}