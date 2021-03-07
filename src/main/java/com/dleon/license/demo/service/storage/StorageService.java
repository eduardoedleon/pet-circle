package com.dleon.license.demo.service.storage;

import com.dleon.license.demo.dto.request.VerifyLicenseRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Async
    public void saveCustomerLicensesInStorage(
            @NotNull VerifyLicenseRequest verifyLicenseRequest,
            @NotNull UploadStorageListener listener) {

        // Executes async task to upload the files in the storage once is successful callback listener.
        // listener.onSuccess( ... );
        // listener.onError( ... );
    }
}
