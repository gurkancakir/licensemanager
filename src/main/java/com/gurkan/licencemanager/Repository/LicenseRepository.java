package com.gurkan.licencemanager.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.gurkan.licencemanager.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LicenseRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public License saveLicense(License license) {
        dynamoDBMapper.save(license);
        return license;
    }

    public License getLicenseById(String licenseId) {
        return dynamoDBMapper.load(License.class, licenseId);
    }

    public String deleteLicenseById(String licenseId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(License.class, licenseId));
        return "License Id : "+ licenseId +" Deleted!";
    }

    public String updateLicense(String LicenseId, License license) {
        dynamoDBMapper.save(license,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("licenseId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(LicenseId)
                                )));
        return LicenseId;
    }
}
