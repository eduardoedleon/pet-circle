package com.dleon.license.demo.service.validator;

import com.dleon.license.demo.dto.license.DriverLicense;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This service will have all the functions necessary to connect to the external component to validate the licenses.
 */
@NotNull
public class LicenseValidator {

    public void validateDriverLicenses(
            @NotNull List<DriverLicense> driverLicenses,
            @NotNull ValidatorListener listener) {

        // Executes async task to save driver licenses in the database
        // listener.onSuccess( ... );
        // listener.onError( ... );
    }
}
