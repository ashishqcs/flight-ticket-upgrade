package com.ashish.sahaj.flightupgrade.service;

import com.ashish.sahaj.flightupgrade.discount.FareClassDiscountStrategy;
import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FareClassDiscountStrategyTest {

    private final FareClassDiscountStrategy fareClassDiscountStrategy = new FareClassDiscountStrategy();

    @ParameterizedTest
    @CsvSource({
            "A, OFFER_20",
            "E, OFFER_20",
            "I, OFFER_30",
            "Z, ''",
    })
    void shouldApplyCorrectFareClassDiscounts(String fareClass, String expectedResult){
        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setFareClass(fareClass);

        assertEquals(expectedResult, fareClassDiscountStrategy.apply(flightTicket));
    }

}