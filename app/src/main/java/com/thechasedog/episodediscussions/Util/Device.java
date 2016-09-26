package com.thechasedog.episodediscussions.Util;

import android.os.Build;

public class Device {
    private static final int ApiVersion = Build.VERSION.SDK_INT;

    public static boolean hasNougatOrGreater() {
        return ApiVersion >= Build.VERSION_CODES.N;
    }
}
