package com.carlfiller.icourtwatch.models;

public class Judge {

    private String name;
    private int court;
    private String defendant;
    private Disposition disposition;

    public Judge(String name, int court, String defendant) {
        this.name = name;
        this.court = court;
        this.defendant = defendant;

    }

    public Judge() {
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
