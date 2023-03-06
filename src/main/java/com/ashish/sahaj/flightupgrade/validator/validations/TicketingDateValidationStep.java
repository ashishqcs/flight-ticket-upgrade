package com.ashish.sahaj.flightupgrade.validator.validations;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.ValidationStep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketingDateValidationStep extends ValidationStep<FlightTicket> {
    @Override
    public ValidationResult validate(FlightTicket ticket) {

        try {
            Date ticketingDate = new SimpleDateFormat("yyyy-MM-dd").parse(ticket.getTicketingDate());
            Date travelDate = new SimpleDateFormat("yyyy-MM-dd").parse(ticket.getTravelDate());

            if (ticketingDate.after(travelDate))
                return ValidationResult.invalid("Ticketing Date invalid");

        } catch (ParseException e) {
            return ValidationResult.invalid("Validation Date Parsing Error");
        }

        return checkNext(ticket);
    }
}
