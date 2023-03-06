package com.ashish.sahaj.flightupgrade.service;
import com.ashish.sahaj.flightupgrade.validator.ValidationResult;

import java.util.List;

public interface DataValidationService<T> {

    ValidationResult validate(T ticket);
    List<T> validateRecords(List<T> tickets) throws Exception;
}
