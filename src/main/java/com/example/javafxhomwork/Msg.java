package com.example.javafxhomwork;

public class Msg{
    String name;
    String address1;
    String address2;
    String email;
    boolean sing;
    boolean dance;
    boolean web;
    boolean football;
    boolean basketball;
    boolean volleyball;
    boolean bachelor;
    boolean master;
    boolean doctor;
    boolean other;
    Msg(String name,
    String address1,
    String address2,
    String email,
    boolean sing,
    boolean dance,
    boolean web,
    boolean football,
    boolean basketball,
    boolean volleyball,
    boolean bachelor,
    boolean master,
    boolean doctor,
    boolean other){
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.email = email;
        this.sing = sing;
        this.dance = dance;
        this.web = web;
        this.football = football;
        this.basketball = basketball;
        this.volleyball = volleyball;
        this.bachelor = bachelor;
        this.master = master;
        this.doctor = doctor;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getEmail() {
        return email;
    }

    public boolean getSing() {
        return sing;
    }

    public boolean getDance() {
        return dance;
    }

    public boolean getWeb() {
        return web;
    }

    public boolean getFootball() {
        return football;
    }
    public boolean getBasketball() {
        return basketball;
    }

    public boolean getVolleyball() {
        return volleyball;
    }

    public boolean getBachelor() {
        return bachelor;
    }

    public boolean getMaster() {
        return master;
    }

    public boolean getDoctor() {
        return doctor;
    }

    public boolean getOther() {
        return other;
    }
}
