package com.example.arnold.campuscarpoolingproject;

public class User {
    String id;
    String destination;
    String time;
    String from;
    String noPassengers;
    String price;


    public User(){

    }

    public User(String id, String destination, String time, String from, String noPassengers,
                String price) {
        this.id = id;
        this.destination = destination;
        this.time = time;
        this.from = from;
        this.noPassengers = noPassengers;
        this.price = price;
        }
//
//    public User(String id, String username, String location, String email,
//                String departmentID, String password, String comfirmPass, String preference,
//                String phone, String userType, String carPlate) {
//    }


    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getNoPassengers() {
        return noPassengers;
    }

    public String getPrice() {
        return price;
    }
}


