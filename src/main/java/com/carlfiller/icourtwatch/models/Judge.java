package com.carlfiller.icourtwatch.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Judge {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int court;

    @OneToMany
    @JoinColumn(name = "judge_id")
    private List<Watch> watches = new ArrayList<>();

    public Judge(String name, int court) {
        this.name = name;
        this.court = court;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCourt(int court) {
        this.court = court;
    }

}
