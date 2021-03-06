package com.gurkan.licencemanager.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gurkan.licencemanager.converter.LocalDateConverter;
import com.gurkan.licencemanager.converter.LocalTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "license")
public class License {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String licenseId;

    @DynamoDBAttribute
    private String licenseKey;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    @JsonFormat(pattern="yyyyMMdd")
    private LocalDate expireDate;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalTimeConverter.class)
    @JsonFormat(pattern="HHmmss")
    private LocalTime expireTime;

    @DynamoDBAttribute
    private Boolean isValid;
}