package com.ashish.sahaj.flightupgrade.discount;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;

public interface DiscountStrategy {

    String apply(FlightTicket ticket);

    boolean isApplicable(String range, FlightTicket ticket);
}
