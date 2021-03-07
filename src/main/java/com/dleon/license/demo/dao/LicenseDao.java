package com.dleon.license.demo.dao;

import com.dleon.license.demo.dto.license.DriverLicense;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LicenseDao {

    public void insertDriverLicenses(
            @NotNull List<DriverLicense> driverLicenses,
            @NotNull DaoListener daoListener) {

        // Executes async task to save driver licenses in the database
        // listener.onSuccess( ... );
        // listener.onError( ... );
    }

    public void updateDriverLicenses(
            @NotNull List<DriverLicense> driverLicenses,
            @NotNull DaoListener daoListener) {

        // Executes async task to update driver licenses in the database
        // listener.onSuccess( ... );
        // listener.onError( ... );
    }
}
