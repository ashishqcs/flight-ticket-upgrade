package com.ashish.sahaj.flightupgrade.validator;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.validator.validations.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {

    @Test
    void shouldValidateCorrectEmail(){
        FlightTicket ticket = FlightTicket.builder().email("ashishsingh@sahaj.com").build();

        EmailValidationStep emailValidationStep = new EmailValidationStep();
        ValidationResult validate = emailValidationStep.validate(ticket);
        assertTrue(validate.isValid());
    }

    @ParameterizedTest
    @CsvSource({
            "ashishsinghnotatsahaj.com",
            "ashishsinghnot@sahajcom",
    })
    void shouldInvalidateIncorrectEmail(String email){
        FlightTicket ticket = FlightTicket.builder().email(email).build();

        EmailValidationStep emailValidationStep = new EmailValidationStep();
        ValidationResult validate = emailValidationStep.validate(ticket);
        assertFalse(validate.isValid());
        assertEquals(validate.getErrorMsg(), "Email Invalid");
    }

    @Test
    void shouldValidateCorrectMobile(){
        FlightTicket ticket = FlightTicket.builder().mobile("8899001122").build();

        MobileValidationStep mobileValidationStep = new MobileValidationStep();
        ValidationResult validate = mobileValidationStep.validate(ticket);
        assertTrue(validate.isValid());
    }

    @Test
    void shouldInValidateIncorrectMobile(){
        FlightTicket ticket = FlightTicket.builder().mobile("123").build();

        MobileValidationStep mobileValidationStep = new MobileValidationStep();
        ValidationResult validate = mobileValidationStep.validate(ticket);
        assertFalse(validate.isValid());
        assertEquals(validate.getErrorMsg(), "Mobile Invalid");
    }

    @Test
    void shouldValidateCorrectPNR(){
        FlightTicket ticket = FlightTicket.builder().pnr("ABC123").build();

        PNRValidationStep pnrValidationStep = new PNRValidationStep();
        ValidationResult validate = pnrValidationStep.validate(ticket);
        assertTrue(validate.isValid());
    }

    @Test
    void shouldInValidateIncorrectPNR(){
        FlightTicket ticket = FlightTicket.builder().pnr("123").build();

        PNRValidationStep pnrValidationStep = new PNRValidationStep();
        ValidationResult validate = pnrValidationStep.validate(ticket);
        assertFalse(validate.isValid());
        assertEquals(validate.getErrorMsg(), "PNR Invalid");
    }

    @Test
    void shouldValidateCorrectTicketingDate(){
        FlightTicket ticket = FlightTicket.builder()
                .ticketingDate("2019-07-31")
                .travelDate("2019-08-21")
                .build();

        TicketingDateValidationStep ticketingDateValidationStep = new TicketingDateValidationStep();
        ValidationResult validate = ticketingDateValidationStep.validate(ticket);
        assertTrue(validate.isValid());
    }

    @Test
    void shouldInValidateIncorrectTicketingDate(){
        FlightTicket ticket = FlightTicket.builder()
                .ticketingDate("2019-07-31")
                .travelDate("2019-05-21")
                .build();

        TicketingDateValidationStep ticketingDateValidationStep = new TicketingDateValidationStep();
        ValidationResult validate = ticketingDateValidationStep.validate(ticket);
        assertFalse(validate.isValid());
        assertEquals(validate.getErrorMsg(), "Ticketing Date invalid");
    }

    @Test
    void shouldValidateCorrectCabin(){
        FlightTicket ticket = FlightTicket.builder().bookedCabin("Economy").build();

        CabinValidationStep cabinValidationStep = new CabinValidationStep();
        ValidationResult validate = cabinValidationStep.validate(ticket);
        assertTrue(validate.isValid());
    }

    @Test
    void shouldInvalidateIncorrectCabin(){
        FlightTicket ticket = FlightTicket.builder().bookedCabin("premium").build();

        CabinValidationStep cabinValidationStep = new CabinValidationStep();
        ValidationResult validate = cabinValidationStep.validate(ticket);
        assertFalse(validate.isValid());
        assertEquals(validate.getErrorMsg(), "Cabin invalid");
    }

}