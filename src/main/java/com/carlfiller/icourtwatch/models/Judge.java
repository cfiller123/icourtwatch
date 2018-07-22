package com.carlfiller.icourtwatch.models;

import javax.validation.constraints.NotNull;

public class Judge {

    @NotNull
    private String name;
    @NotNull
    private String court;
    @NotNull
    private String defendant;
    @NotNull
    private Disposition disposition;

}
