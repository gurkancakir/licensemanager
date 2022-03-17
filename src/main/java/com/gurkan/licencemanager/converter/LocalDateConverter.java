package com.gurkan.licencemanager.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public String convert(LocalDate date) {
        return formatter.format(date);
    }

    @Override
    public LocalDate unconvert(String date) {
        return LocalDate.from(formatter.parse(date));
    }
}
