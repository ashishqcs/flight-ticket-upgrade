package com.ashish.sahaj.flightupgrade;

import com.ashish.sahaj.flightupgrade.discount.FareClassDiscountStrategy;
import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.ashish.sahaj.flightupgrade.service.DefaultTicketDataValidationService;
import com.ashish.sahaj.flightupgrade.service.DiscountService;
import com.ashish.sahaj.flightupgrade.util.CSVFileReadWrite;

import java.util.List;

public class FlightTicketApplication {

    private final CSVFileReadWrite fileReadWrite = new CSVFileReadWrite();
    private final DefaultTicketDataValidationService validationService = new DefaultTicketDataValidationService();
    private final DiscountService discountService = new DiscountService();

    void upgradeFlightTicket(String readFilePath, String errorFilePath, String discountFilePath) throws Exception {

        List<FlightTicket> tickets = fileReadWrite.read(readFilePath);
        List<FlightTicket> failedTickets = validationService.validateRecords(tickets);
        fileReadWrite.write(failedTickets, errorFilePath);
        tickets = discountService.applyDiscount(tickets, new FareClassDiscountStrategy());
        fileReadWrite.write(tickets, discountFilePath);
    }
}
