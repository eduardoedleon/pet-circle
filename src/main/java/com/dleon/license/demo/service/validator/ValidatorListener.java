package com.dleon.license.demo.service.validator;

import org.jetbrains.annotations.NotNull;

public interface ValidatorListener {

    void onSuccess(boolean areValidDriverLicenses);

    void onError(@NotNull Throwable exception);
}
