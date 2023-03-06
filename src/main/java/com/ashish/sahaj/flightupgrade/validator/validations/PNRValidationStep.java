package com.ashish.sahaj.flightupgrade.validator.validations;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.ValidationStep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PNRValidationStep extends ValidationStep<FlightTicket> {
    String regex = "[A-Za-z0-9]{6}";

    @Override
    public ValidationResult validate(FlightTicket ticket) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ticket.getPnr().trim());
        if (!matcher.matches()) {
            return ValidationResult.invalid("PNR Invalid");
        }
        return checkNext(ticket);
    }
}
