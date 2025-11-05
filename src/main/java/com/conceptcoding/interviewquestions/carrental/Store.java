package com.conceptcoding.interviewquestions.carrental;

import com.conceptcoding.interviewquestions.carrental.payment.Payment;
import com.conceptcoding.interviewquestions.carrental.payment.PaymentMode;
import com.conceptcoding.interviewquestions.carrental.product.Vehicle;
import com.conceptcoding.interviewquestions.carrental.product.VehicleInventoryManagement;
import com.conceptcoding.interviewquestions.carrental.product.VehicleStatus;
import com.conceptcoding.interviewquestions.carrental.product.VehicleType;
import com.conceptcoding.interviewquestions.carrental.reservation.Reservation;
import com.conceptcoding.interviewquestions.carrental.reservation.ReservationStatus;
import com.conceptcoding.interviewquestions.carrental.reservation.ReservationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    int storeId;
    Location storeLocation;
    VehicleInventoryManagement inventoryManagement;
    List<Reservation> reservations;
    List<Reservation> reservationHistory;


    public Store(int storeId, Location storeLocation) {
        this.storeId = storeId;
        this.storeLocation = storeLocation;
        inventoryManagement = new VehicleInventoryManagement();
        reservations = new ArrayList<>();
        reservationHistory = new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public VehicleInventoryManagement getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(VehicleInventoryManagement inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservationHistory() {
        return reservationHistory;
    }

    public void setReservationHistory(List<Reservation> reservationHistory) {
        this.reservationHistory = reservationHistory;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles();
    }

    public void addVehicle(Vehicle vehicle) {
        inventoryManagement.addVehicle(vehicle);
    }

    public void updateVehicle(Vehicle vehicle) {
        inventoryManagement.updateVehicle(vehicle);
    }

    public void updateVehicleStatus(int vehicleId, VehicleStatus vehicleStatus) {
        inventoryManagement.updateVehicleStatus(vehicleId, vehicleStatus);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement.setVehicles(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user, LocalDate fromDate, LocalDate toDate, ReservationType type) {
        Reservation reservation = new Reservation();
        reservation = reservation.createReservation(vehicle, user, fromDate, toDate, storeLocation, storeLocation, type);
        reservations.add(reservation);
        inventoryManagement.updateVehicleStatus(vehicle.getVehicleID(), VehicleStatus.BOOKED);
        return reservation;
    }

    public void updateReservation(Reservation reservation, ReservationStatus status) {
        reservations.stream().filter(r -> r.getReservationId() == reservation.getReservationId()).findFirst()
                .ifPresent(r -> r.setReservationStatus(status));
    }

    public boolean submitVehicle(int reservationID) {
        Reservation reservation = reservations.stream().filter(r -> r.getReservationId() == reservationID).findFirst().get();
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        return true;
    }

    public void cancelReservation(int reservationID) {
        Reservation reservation = reservations.get(reservationID);
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        reservations.remove(reservationID);
        reservationHistory.add(reservation);
        inventoryManagement.updateVehicleStatus(reservation.getVehicle().getVehicleID(), VehicleStatus.AVAILABLE);
    }

    public Bill generateBill(int reservationID) {
        Reservation reservation = reservations.stream().filter(r -> r.getReservationId() == reservationID).findFirst().get();
        return new Bill(reservation);
    }

    public void makePayment(Bill bill, PaymentMode paymentMode) {
        Payment payment = new Payment(bill);
        payment.processPayment(paymentMode);
        reservations.remove(bill.getReservation());
        inventoryManagement.updateVehicleStatus(bill.getReservation().getVehicle().getVehicleID(), VehicleStatus.AVAILABLE);
        reservationHistory.add(bill.getReservation());
    }
}