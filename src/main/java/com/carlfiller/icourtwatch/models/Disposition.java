package com.carlfiller.icourtwatch.models;

//import javax.persistence.Entity;
//
//@Entity
public enum Disposition {

    CONTINUANCE ("Continuance"),
    DISMISSED ("Dismissed"),
    GUILTY ("Guilty"),
    NOTGUILTY ("Not Guilty");

    private final String name;

    Disposition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
