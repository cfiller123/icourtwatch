package com.carlfiller.icourtwatch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Judge {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int court;

    // TODO: Add a date and update controller and views accordingly

    @NotNull
    private String defendant;

    private Disposition disposition;

    public Judge(String name, int court, String defendant) {
        this.name = name;
        this.court = court;
        this.defendant = defendant;

    }

    public Judge() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCourt() {
        return court;
    }

    public String getDefendant() {
        return defendant;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourt(int court) {
        this.court = court;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }
}
