package com.ashish.sahaj.flightupgrade;

import com.ashish.sahaj.flightupgrade.util.CSVFileReadWrite;
import com.ashish.sahaj.flightupgrade.util.FileReadWrite;
import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightTicketApplicationTest {

    private final FlightTicketApplication flightTicketApplication = new FlightTicketApplication();
    private final FileReadWrite<FlightTicket> csvReaderWriter = new CSVFileReadWrite();


    @Test
    void shouldProcessRecordsAndGenerateFilesForFlightUpgrade() throws Exception {
        flightTicketApplication.upgradeFlightTicket(
                "src/test/resources/TicketInfo.csv",
                "src/test/resources/Errors.csv",
                "src/test/resources/Discounts.csv"
        );

        List<FlightTicket> flightTickets = csvReaderWriter.read("src/test/resources/Errors.csv");
        assertEquals(2, flightTickets.size());

        flightTickets = csvReaderWriter.read("src/test/resources/Discounts.csv");
        assertEquals(3, flightTickets.size());
    }

    @Test
    void shouldGenerateDiscountFileForEligibleTickets() throws Exception {
        flightTicketApplication.upgradeFlightTicket(
                "src/test/resources/TicketInfo.csv",
                "src/test/resources/Errors.csv",
                "src/test/resources/Discounts.csv"
        );

        List<FlightTicket> discountRecords = csvReaderWriter.read("src/test/resources/Discounts.csv");
        assertEquals(3, discountRecords.size());
        assertEquals("OFFER_30", discountRecords.get(0).getDiscountCode());
        assertEquals("OFFER_25", discountRecords.get(1).getDiscountCode());
        assertEquals("", discountRecords.get(2).getDiscountCode());
    }

    @Test
    void shouldGenerateErrorFile() throws Exception {
        flightTicketApplication.upgradeFlightTicket(
                "src/test/resources/TicketInfo.csv",
                "src/test/resources/Errors.csv",
                "src/test/resources/Discounts.csv"
        );

        List<FlightTicket> error = csvReaderWriter.read("src/test/resources/Errors.csv");
        assertEquals(2, error.size());
        assertEquals("PNR Invalid", error.get(0).getError());
        assertEquals("Email Invalid", error.get(1).getError());
    }
}