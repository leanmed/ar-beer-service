package com.lmedin.arbeerservice.model;

import java.util.stream.Stream;

public enum BeerStyleEnum {

    LARGER("LARGER"),
    PISLSNER("PISLSNER"),
    ALE("ALE"),
    STOUT("STOUT"),
    IPA("IPA"),
    GOLD("GOLD");

    public String typeOfBeer;

    BeerStyleEnum(String type){
        this.typeOfBeer = type;
    }

    public static BeerStyleEnum decode(final String typeOfBeer) {
        return Stream.of(BeerStyleEnum.values()).filter(targetEnum -> targetEnum.typeOfBeer.equals(typeOfBeer)).findFirst().orElse(null);
    }

    public String getTypeOfBeer() {
        return typeOfBeer;
    }
}
