package com.dleon.license.demo.dto.license;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DriverLicense {

    private final String email;
    private final String driveLicenseURL;
    private final DriverLicenseStatus status;

    public DriverLicense(
            @NotNull String email,
            @Nullable String driveLicenseURL,
            @NotNull DriverLicenseStatus status) {
        this.email = email;
        this.driveLicenseURL = driveLicenseURL;
        this.status = status;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    @Nullable
    public String getDriveLicenseURL() {
        return driveLicenseURL;
    }

    @NotNull
    public DriverLicenseStatus getStatus() {
        return status;
    }
}
