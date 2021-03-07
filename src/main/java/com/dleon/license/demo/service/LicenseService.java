package com.dleon.license.demo.service;

import com.dleon.license.demo.dao.DaoListener;
import com.dleon.license.demo.dao.LicenseDao;
import com.dleon.license.demo.dto.license.DriverLicense;
import com.dleon.license.demo.dto.request.VerifyLicenseRequest;
import com.dleon.license.demo.service.storage.StorageService;
import com.dleon.license.demo.service.storage.UploadStorageListener;
import com.dleon.license.demo.service.validator.LicenseValidator;
import com.dleon.license.demo.service.validator.ValidatorListener;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    private final LicenseDao licenseDao;
    private final StorageService storageService;
    private final LicenseValidator licenseValidator;

    public LicenseService(
            @NotNull LicenseDao licenseDao,
            @NotNull StorageService storageService,
            @NotNull LicenseValidator licenseValidator) {
        this.licenseDao = licenseDao;
        this.storageService = storageService;
        this.licenseValidator = licenseValidator;
    }

    public void verifyLicenses(@NotNull VerifyLicenseRequest verifyLicenseRequest) {

        // Once the basic in the controller are done, the service should sent the driver licenses to the storage
        // Such as AWS s3 or Cloud Storage.

        UploadStorageListener listener = new UploadStorageListener() {
            @Override
            public void onSuccess(@NotNull List<DriverLicense> driverLicenses) {
                // Saves licenses status in database
                saveDriverLicenses(driverLicenses);
            }

            @Override
            public void onError(@NotNull Throwable exception) {
                // Notify that an exception occurred
            }
        };

        storageService.saveCustomerLicensesInStorage(
                verifyLicenseRequest,
                listener);
    }

    private void saveDriverLicenses(@NotNull List<DriverLicense> driverLicenses) {
        DaoListener daoListener = new DaoListener() {
            @Override
            public void onSuccess(@NotNull List<DriverLicense> driverLicenses) {
                manageDriverLicensesValidation(driverLicenses);
            }

            @Override
            public void onError(@NotNull Throwable exception) {
                // Notify that an exception occurred
            }
        };

        licenseDao.insertDriverLicenses(
                driverLicenses,
                daoListener);
    }

    private void manageDriverLicensesValidation(@NotNull List<DriverLicense> driverLicenses) {

        ValidatorListener validatorListener = new ValidatorListener() {
            @Override
            public void onSuccess(boolean areValidDriverLicenses) {

                if (areValidDriverLicenses) {
                    // Once the licenses are valid by the third party we should check if the dates are within the booking date
                    // Maybe that information is provided by the third party

                    // Furthermore if everything is correct the driver licenses should be updated to Status accepted in the database.
                } else {
                    // Once the licenses are not valid by the third party we should notify the staff who will take
                    // the decision either cancel or ask for more licenses

                    // Furthermore the driver licenses should be updated to Status refused in the database.
                }
            }

            @Override
            public void onError(@NotNull Throwable exception) {
                // Notify that an exception occurred
            }
        };

        // Validate the driver license with an external third party.
        licenseValidator.validateDriverLicenses(
                driverLicenses,
                validatorListener);
    }

}
