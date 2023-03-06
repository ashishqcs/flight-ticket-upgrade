package com.ashish.sahaj.flightupgrade.discount;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.ashish.sahaj.flightupgrade.discount.FareClassDiscountStrategy.Discounts.*;

public class FareClassDiscountStrategy implements DiscountStrategy {

    enum Discounts {
        OFFER_20,
        OFFER_25,
        OFFER_30
    }

    private static final Map<String, Discounts> discountsMap = Map.of(
            "A - E", OFFER_20,
            "F - K", OFFER_30,
            "L - R", OFFER_25
    );

    @Override
    public String apply(FlightTicket ticket) {
        for (Map.Entry<String, Discounts> entry : discountsMap.entrySet()) {
            if (isApplicable(entry.getKey(), ticket))
                return entry.getValue().name();
        }
        return StringUtils.EMPTY;
    }

    @Override
    public boolean isApplicable(String fareClassRange, FlightTicket ticket) {
        char floor = fareClassRange.charAt(0);
        char ceil = fareClassRange.charAt(4);
        char fareClass = ticket.getFareClass().trim().charAt(0);
        return fareClass >= floor && fareClass <= ceil;
    }
}
