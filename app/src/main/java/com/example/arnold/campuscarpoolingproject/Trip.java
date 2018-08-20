package com.example.arnold.campuscarpoolingproject;

public class Trip {
    private String destination;
    private String time;
    private String from;
    private String seats_available;
    private String car_plate;
    private String name;
    private String drivers_tel;
    private String price;


    public Trip(){

    }

    public Trip(String destination, String time,
                String from, String seats_available,
                String car_plate, String name,
                String drivers_tel, String price) {
        this.destination = destination;
        this.time = time;
        this.from = from;
        this.seats_available = seats_available;
        this.car_plate = car_plate;
        this.name = name;
        this.drivers_tel = drivers_tel;
        this.price = price;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(String seats_available) {
        this.seats_available = seats_available;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrivers_tel() {
        return drivers_tel;
    }

    public void setDrivers_tel(String drivers_tel) {
        this.drivers_tel = drivers_tel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
