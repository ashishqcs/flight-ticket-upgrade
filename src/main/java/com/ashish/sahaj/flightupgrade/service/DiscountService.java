package com.ashish.sahaj.flightupgrade.service;

import com.ashish.sahaj.flightupgrade.discount.DiscountStrategy;
import com.ashish.sahaj.flightupgrade.model.FlightTicket;

import java.util.List;

public class DiscountService {

    public List<FlightTicket> applyDiscount(List<FlightTicket> tickets, DiscountStrategy discountStrategy) {
        tickets.forEach(ticket -> {
            String discountCode = discountStrategy.apply(ticket);
            ticket.setDiscountCode(discountCode);
        });

        return tickets;
    }

}
