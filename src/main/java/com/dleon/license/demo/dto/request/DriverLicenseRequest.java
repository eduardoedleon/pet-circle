package com.dleon.license.demo.dto.request;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class DriverLicenseRequest {
    private final String email;
    private final MultipartFile driverLicenseFile;

    public DriverLicenseRequest(
            @NotNull String email,
            @NotNull MultipartFile driverLicenseFile) {
        this.email = email;
        this.driverLicenseFile = driverLicenseFile;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    @NotNull
    public MultipartFile getDriverLicenseFile() {
        return driverLicenseFile;
    }
}
