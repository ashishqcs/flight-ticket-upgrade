package com.ashish.sahaj.flightupgrade.service;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.validations.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultTicketDataValidationService implements DataValidationService<FlightTicket> {

    @Override
    public ValidationResult validate(FlightTicket ticket) {
        return new EmailValidationStep()
                .linkWith(new MobileValidationStep())
                .linkWith(new PNRValidationStep())
                .linkWith(new TicketingDateValidationStep())
                .linkWith(new CabinValidationStep())
                .validate(ticket);
    }

    @Override
    public List<FlightTicket> validateRecords(List<FlightTicket> tickets) throws Exception {
        List<FlightTicket> allTickets = new ArrayList<>(tickets);
        tickets.clear();
        return allTickets.stream().filter(ticket ->
        {
            ValidationResult result = validate(ticket);
            if (result.notValid())
                ticket.setError(result.getErrorMsg());
            else
                tickets.add(ticket);
            return result.notValid();
        }).toList();
    }

}
