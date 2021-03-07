package com.dleon.license.demo.dao;

import com.dleon.license.demo.dto.license.DriverLicense;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface DaoListener {

    void onSuccess(@NotNull List<DriverLicense> driverLicenses);

    void onError(@NotNull Throwable exception);
}
