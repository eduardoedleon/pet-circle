package com.dleon.license.demo.controller;

import com.dleon.license.demo.dto.request.VerifyLicenseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LicenseController {

    private final Logger logger = LoggerFactory.getLogger(LicenseController.class);

    @RequestMapping(value = "/verifyLicenses", method = RequestMethod.POST)
    public ResponseEntity<String> verifyLicenses(@ModelAttribute VerifyLicenseRequest verifyLicenseRequest) {

        this.logger.info(String.format(
                "Verifying licenses booking code: %s, driver licenses: %s",
                verifyLicenseRequest.getBookingCode(),
                verifyLicenseRequest.getDriverLicenseRequests().size()));

        if (verifyLicenseRequest.getBookingCode().isEmpty()) {
            this.logger.error("No booking code found");
            return new ResponseEntity<>("Please verify request, no booking code found", HttpStatus.BAD_REQUEST);
        }

        if (verifyLicenseRequest.getDriverLicenseRequests().isEmpty()) {
            this.logger.error("No licenses found");
            return new ResponseEntity<>("Please verify request, no licenses found", HttpStatus.BAD_REQUEST);
        } else {
            this.logger.info("Proceeding to verify licenses");
            return new ResponseEntity<>("A notification will be sent to you once the driver licenses have been certificated", HttpStatus.ACCEPTED);
        }
    }
}
