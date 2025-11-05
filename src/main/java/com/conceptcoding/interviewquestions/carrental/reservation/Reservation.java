package com.conceptcoding.interviewquestions.carrental.reservation;

import com.conceptcoding.interviewquestions.carrental.Location;
import com.conceptcoding.interviewquestions.carrental.User;
import com.conceptcoding.interviewquestions.carrental.product.Vehicle;

import java.time.LocalDate;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    LocalDate bookingDate;
    LocalDate dateBookedFrom;
    LocalDate dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;


    public Reservation(int reservationId, User user, Vehicle vehicle, LocalDate dateBookedFrom, LocalDate dateBookedTo, Location pickUpLocation, Location dropLocation, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.reservationType = reservationType;
    }

    public Reservation(int reservationId, User user, Vehicle vehicle, Long fromTimeStamp, Long toTimeStamp, Location pickUpLocation, Location dropLocation, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.fromTimeStamp = fromTimeStamp;
        this.toTimeStamp = toTimeStamp;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.reservationType = reservationType;
    }

    public Reservation() {

    }

    public Reservation createReservation(Vehicle vehicle, User user, LocalDate dateBookedFrom, LocalDate dateBookedTo,
                                         Location pickUpLocation, Location dropLocation, ReservationType reservationType) {
        reservationId = generateReservationId();
        return new Reservation(reservationId, user, vehicle, dateBookedFrom, dateBookedTo, pickUpLocation, dropLocation, reservationType);
    }

    public Reservation createReservation(Vehicle vehicle, User user, Long fromTimeStamp, Long toTimeStamp,
                                         Location pickUpLocation, Location dropLocation, ReservationType reservationType) {
        reservationId = generateReservationId();
        return new Reservation(reservationId, user, vehicle, fromTimeStamp, toTimeStamp, pickUpLocation, dropLocation, reservationType);
    }

    private int generateReservationId() {
        return (int) (Math.random() * (30000 - 20000 + 1)) + 20000;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Long getToTimeStamp() {
        return toTimeStamp;
    }

    public void setToTimeStamp(Long toTimeStamp) {
        this.toTimeStamp = toTimeStamp;
    }

    public Long getFromTimeStamp() {
        return fromTimeStamp;
    }

    public void setFromTimeStamp(Long fromTimeStamp) {
        this.fromTimeStamp = fromTimeStamp;
    }

    public LocalDate getDateBookedTo() {
        return dateBookedTo;
    }

    public void setDateBookedTo(LocalDate dateBookedTo) {
        this.dateBookedTo = dateBookedTo;
    }

    public LocalDate getDateBookedFrom() {
        return dateBookedFrom;
    }

    public void setDateBookedFrom(LocalDate dateBookedFrom) {
        this.dateBookedFrom = dateBookedFrom;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
