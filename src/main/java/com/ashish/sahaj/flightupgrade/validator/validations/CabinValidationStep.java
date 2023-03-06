package com.ashish.sahaj.flightupgrade.validator.validations;

import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import com.ashish.sahaj.flightupgrade.validator.ValidationStep;
import com.ashish.sahaj.flightupgrade.model.FlightTicket;

public class CabinValidationStep extends ValidationStep<FlightTicket> {
    private enum CabinType {
        ECONOMY("Economy"),
        PREMIUM_ECONOMY("Premium Economy"),
        BUSINESS("Business"),
        FIRST("First");

        private final String value;

        CabinType(String cabin) {
            this.value = cabin;
        }

        public static CabinType of(String input) {
            for (CabinType productType : CabinType.values()) {
                if (input.equalsIgnoreCase(productType.value)) {
                    return productType;
                }
            }

            throw new RuntimeException("Invalid Cabin");
        }
    }

    @Override
    public ValidationResult validate(FlightTicket ticket) {
        try {
            CabinType.of(ticket.getBookedCabin().trim());
        } catch (Exception ex) {
            return ValidationResult.invalid("Cabin invalid");
        }
        return checkNext(ticket);
    }
}
