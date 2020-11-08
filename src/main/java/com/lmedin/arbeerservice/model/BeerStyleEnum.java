package com.lmedin.arbeerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum BeerStyleEnum {

    LARGER("LARGER"),
    PISLSNER("PISLSNER"),
    ALE("ALE"),
    STOUT("STOUT"),
    IPA("IPA"),
    GOLD("GOLD");

    public final String typeOfBeer;

    private BeerStyleEnum(String type){
        this.typeOfBeer = type;
    }
}
