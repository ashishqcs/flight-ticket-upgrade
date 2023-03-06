package com.ashish.sahaj.flightupgrade.service;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.util.CSVFileReadWrite;
import com.ashish.sahaj.flightupgrade.util.FileReadWrite;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTicketDataValidationServiceTest {

    private final FileReadWrite<FlightTicket> csvReaderWriter = new CSVFileReadWrite();

    private final DefaultTicketDataValidationService service = new DefaultTicketDataValidationService();

    @Test
    void shouldValidateTicket() throws IOException {

        List<FlightTicket> flightTickets = csvReaderWriter.read("src/test/resources/TicketInfo.csv");
        ValidationResult validate = service.validate(flightTickets.get(0));
        assertTrue(validate.isValid());
    }
}