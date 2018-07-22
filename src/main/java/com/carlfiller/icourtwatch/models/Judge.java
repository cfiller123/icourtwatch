package com.carlfiller.icourtwatch.models;

import javax.validation.constraints.NotNull;

public class Judge {

    private String name;
    private String court;
    private String defendant;
    private Disposition disposition;

    public String getName() {
        return name;
    }

    public String getCourt() {
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

    public void setCourt(String court) {
        this.court = court;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }
}
