package com.dleon.license.demo.service.storage;

import com.dleon.license.demo.dto.license.DriverLicense;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UploadStorageListener {

    void onSuccess(@NotNull List<DriverLicense> driverLicenses);

    void onError(@NotNull Throwable exception);
}
