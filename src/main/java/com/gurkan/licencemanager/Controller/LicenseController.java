package com.gurkan.licencemanager.Controller;

import com.gurkan.licencemanager.Repository.LicenseRepository;
import com.gurkan.licencemanager.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class LicenseController {

    @Autowired
    private LicenseRepository licenseRepository;

    @PostMapping("/license")
    public License saveLicense(@RequestBody License License) {
        return licenseRepository.saveLicense(License);
    }

    @GetMapping("/license/{id}")
    public License getLicenseById(@PathVariable("id") String LicenseId) {
        return licenseRepository.getLicenseById(LicenseId);
    }

    @DeleteMapping("/license/{id}")
    public String deleteLicenseById(@PathVariable("id") String LicenseId) {
        return  licenseRepository.deleteLicenseById(LicenseId);
    }

    @PutMapping("/license/{id}")
    public String updateLicense(@PathVariable("id") String LicenseId, @RequestBody License License) {
        return licenseRepository.updateLicense(LicenseId,License);
    }
}
