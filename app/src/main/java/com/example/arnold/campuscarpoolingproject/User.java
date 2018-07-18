package com.example.arnold.campuscarpoolingproject;

public class User {
    String id;
    String username;
    String userLocation;
    String userEmail;
    String userDepartmentID;
    String userPassword;
    String userComfirmPass;
    String userPreference;
    String userPhone;
    String userCarplate;
    String typeofuser;

    public User(){

    }

    public User(String idd, String username, String userLocation, String userEmail, String userDepartmentID,
                String userPassword, String userPreference, String userPhone,
                String userCarplate, String typeofUser) {
        this.id = idd;
        this.username = username;
        this.userLocation = userLocation;
        this.userEmail = userEmail;
        this.userDepartmentID = userDepartmentID;
        this.userPassword = userPassword;
         this.userPreference = userPreference;
        this.userPhone = userPhone;
        this.userCarplate = userCarplate;
        this.typeofuser = typeofUser;
    }
//
//    public User(String id, String username, String location, String email,
//                String departmentID, String password, String comfirmPass, String preference,
//                String phone, String userType, String carPlate) {
//    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserDepartmentID() {
        return userDepartmentID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserComfirmPass() {
        return userComfirmPass;
    }

    public String getUserPreference() {
        return userPreference;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserCarplate() {
        return userCarplate;
    }


    public String getTypeofuser() {
        return typeofuser;
    }
}


