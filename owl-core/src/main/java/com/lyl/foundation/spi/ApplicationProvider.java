package com.lyl.foundation.spi;

import java.io.InputStream;

public interface ApplicationProvider extends Provider {

    String getAppId();
    boolean isAppIdSet();
    void initialize(InputStream in);

}
