package com.gurkan.licencemanager.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class LocalTimeConverter implements DynamoDBTypeConverter<String, LocalTime> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");

    @Override
    public String convert(LocalTime date) {
        return formatter.format(date);
    }

    @Override
    public LocalTime unconvert(String date) {
        return LocalTime.from(formatter.parse(date));
    }
}
