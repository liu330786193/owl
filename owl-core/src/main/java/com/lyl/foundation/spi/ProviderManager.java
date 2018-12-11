package com.lyl.foundation.spi;

public interface ProviderManager {

    String getProperty(String name, String defaultValue);
    <T extends Provider> T provider(Class<T> clazz);

}
