package com.carlfiller.icourtwatch.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Judge {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int court;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    private String defendant;

    private Disposition disposition;

    public Judge(String name, int court, Date date, String defendant) {
        this.name = name;
        this.court = court;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
