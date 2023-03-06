package com.ashish.sahaj.flightupgrade.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightTicket {

    @CsvBindByName(column = "First_name")
    private String firstName;
    @CsvBindByName(column = "Last_name")
    private String lastName;
    @CsvBindByName(column = "PNR")
    private String pnr;
    @CsvBindByName(column = "Fare_class")
    private String fareClass;
    @CsvBindByName(column = "Travel_date")
    private String travelDate;
    @CsvBindByName(column = "Pax")
    private String pax;
    @CsvBindByName(column = "Ticketing_date")
    private String ticketingDate;
    @CsvBindByName(column = "Email")
    private String email;
    @CsvBindByName(column = "Mobile_phone")
    private String mobile;
    @CsvBindByName(column = "Booked_cabin")
    private String bookedCabin;
    @CsvBindByName(column = "Discount_code")
    private String discountCode;
    @CsvBindByName(column = "Error")
    private String error;
}
