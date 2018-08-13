package com.example.arnold.campuscarpoolingproject;

public class User {

    private String destination;

    private String time;

    private String from;

    private String noPassengers;

    private String price;

    public User(){

    }

    public User(String destination, String time, String from, String noPassengers,
                String price) {
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

    public void setTime(String time) {
        this.time = time;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setNoPassengers(String nopassengers) {
        this.noPassengers = nopassengers;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    //
    /*public void setid(String id) {
        this.id = id;
    }*/
}


