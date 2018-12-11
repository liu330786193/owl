package com.lyl.foundation.internals.provider;

import com.lyl.foundation.spi.ApplicationProvider;
import com.lyl.foundation.spi.NetworkProvider;
import com.lyl.foundation.spi.Provider;
import com.lyl.foundation.spi.ServerProvider;

import java.io.InputStream;

public class NullProvider implements ApplicationProvider, NetworkProvider, ServerProvider {

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public boolean isAppIdSet() {
        return false;
    }

    @Override
    public String getEnvType() {
        return null;
    }

    @Override
    public boolean isEnvTypeSet() {
        return false;
    }

    @Override
    public String getDataCenter() {
        return null;
    }

    @Override
    public boolean isDataCenterSet() {
        return false;
    }

    @Override
    public void initialize(InputStream in) {

    }

    @Override
    public String getHostAddress() {
        return null;
    }

    @Override
    public String getHostName() {
        return null;
    }

    @Override
    public Class<? extends Provider> getType() {
        return null;
    }

    @Override
    public String getProperty(String name, String defaultValue) {
        return defaultValue;
    }

    @Override
    public void initialize() {

    }

    @Override
    public String toString() {
        return "(NullProvider)";
    }
}
