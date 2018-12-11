package com.lyl.foundation.internals;

import com.lyl.foundation.internals.provider.NullProvider;
import com.lyl.foundation.spi.ProviderManager;

import java.security.Provider;

public class NullProviderManager implements ProviderManager {

    public static final NullProvider provider = new NullProvider();

    @Override
    public String getProperty(String name, String defaultValue) {
        return defaultValue;
    }

    @Override
    public NullProvider provider(Class clazz) {
        return provider;
    }

    @Override
    public String toString() {
        return provider.toString();
    }
}
