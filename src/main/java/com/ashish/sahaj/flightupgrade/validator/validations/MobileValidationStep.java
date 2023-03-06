package com.ashish.sahaj.flightupgrade.validator.validations;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.ValidationStep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileValidationStep extends ValidationStep<FlightTicket> {
    String regex = "[7-9][0-9]{9}";

    @Override
    public ValidationResult validate(FlightTicket ticket) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ticket.getMobile().trim());
        if (!matcher.matches()) {
            return ValidationResult.invalid("Mobile Invalid");
        }
        return checkNext(ticket);
    }
}
