package com.ashish.sahaj.flightupgrade.util;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVFileReadWriteTest {

    private final FileReadWrite<FlightTicket> csvReaderWriter = new CSVFileReadWrite();

    @Test
    void shouldReadFromCSVFile() throws IOException {
        List<FlightTicket> flightTickets = csvReaderWriter.read("src/test/resources/TicketInfo.csv");

        assertEquals(5, flightTickets.size());
        assertEquals("Abhi s h e k ", flightTickets.get(0).getFirstName());
        assertEquals(" Economy", flightTickets.get(0).getBookedCabin());
    }

    @Test
    void shouldWriteBeanToCSVFile() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        csvReaderWriter.write(List.of(getFlightTicket()), "src/main/resources/ErrorRecords.csv");
        List<FlightTicket> flightTickets = csvReaderWriter.read("src/main/resources/ErrorRecords.csv");
        assertEquals(1, flightTickets.size());
    }

    private FlightTicket getFlightTicket() {

        return FlightTicket.builder()
                .firstName("Ashish")
                .lastName("Singh")
                .build();
    }
}