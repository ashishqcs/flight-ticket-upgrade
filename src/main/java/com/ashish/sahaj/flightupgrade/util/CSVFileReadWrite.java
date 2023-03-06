package com.ashish.sahaj.flightupgrade.util;

import com.ashish.sahaj.flightupgrade.model.FlightTicket;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVFileReadWrite implements FileReadWrite<FlightTicket> {

    @Override
    public List<FlightTicket> read(String filePath) throws IOException {
        List<FlightTicket> items;
        try (Reader reader = Files.newBufferedReader(Path.of(filePath))) {
            CsvToBean<FlightTicket> cb = new CsvToBeanBuilder<FlightTicket>(reader)
                    .withType(FlightTicket.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            items = cb.parse();
        }
        return items;
    }

    @Override
    public void write(List<FlightTicket> items, String filePath) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try (FileWriter writer = new FileWriter(filePath)) {
            StatefulBeanToCsv<FlightTicket> statefulBeanToCsv = new StatefulBeanToCsvBuilder<FlightTicket>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withApplyQuotesToAll(false)
                    .build();

            statefulBeanToCsv.write(items);
        }
    }
}
