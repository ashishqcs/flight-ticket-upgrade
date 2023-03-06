package com.ashish.sahaj.flightupgrade.validator.validations;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.ValidationStep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationStep extends ValidationStep<FlightTicket> {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public ValidationResult validate(FlightTicket ticket) {

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(ticket.getEmail().trim());
        if (!matcher.matches()) {
            return ValidationResult.invalid("Email Invalid");
        }
        return checkNext(ticket);
    }
}
