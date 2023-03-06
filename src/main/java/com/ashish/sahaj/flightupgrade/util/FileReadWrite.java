package com.ashish.sahaj.flightupgrade.util;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public interface FileReadWrite<T> {

    List<T> read(String filePath) throws IOException;

    void write(List<T> object, String filePath) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
}
