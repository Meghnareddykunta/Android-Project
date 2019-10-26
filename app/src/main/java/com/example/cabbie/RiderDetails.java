package com.example.cabbie;

import java.io.Serializable;

public class RiderDetails implements Serializable {
    String name;
    String fromAddress;
    String toAddress;
    String fromCity;
    String fromState;
    String fromZipCode;
    String toCity;
    String toState;
    String toZipCode;
    String date;
    String time;
    int resId;
    String phone;

    public RiderDetails() {
    }

    public RiderDetails(String name, String fromAddress, String toAddress, String fromCity, String fromState, String fromZipCode, String toCity, String toState, String toZipCode, String date, String time, int resId, String phone) {
        this.name = name;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.fromCity = fromCity;
        this.fromState = fromState;
        this.fromZipCode = fromZipCode;
        this.toCity = toCity;
        this.toState = toState;
        this.toZipCode = toZipCode;
        this.date = date;
        this.time = time;
        this.resId = resId;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromState() {
        return fromState;
    }

    public void setFromState(String fromState) {
        this.fromState = fromState;
    }

    public String getFromZipCode() {
        return fromZipCode;
    }

    public void setFromZipCode(String fromZipCode) {
        this.fromZipCode = fromZipCode;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToState() {
        return toState;
    }

    public void setToState(String toState) {
        this.toState = toState;
    }

    public String getToZipCode() {
        return toZipCode;
    }

    public void setToZipCode(String toZipCode) {
        this.toZipCode = toZipCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DriverDetails{" +
                "name='" + name + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", fromState='" + fromState + '\'' +
                ", fromZipCode='" + fromZipCode + '\'' +
                ", toCity='" + toCity + '\'' +
                ", toState='" + toState + '\'' +
                ", toZipCode='" + toZipCode + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", resId=" + resId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
