package com.dleon.license.demo.dto.request;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VerifyLicenseRequest {

    private final String bookingCode;
    private final List<DriverLicenseRequest> driverLicenseRequests;

    public VerifyLicenseRequest(
            @NotNull String bookingCode,
            @NotNull List<DriverLicenseRequest> driverLicenseRequests) {
        this.bookingCode = bookingCode;
        this.driverLicenseRequests = driverLicenseRequests;
    }

    @NotNull
    public String getBookingCode() {
        return bookingCode;
    }

    @NotNull
    public List<DriverLicenseRequest> getDriverLicenseRequests() {
        return driverLicenseRequests;
    }
}
