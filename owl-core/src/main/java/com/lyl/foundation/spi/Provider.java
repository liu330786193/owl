package com.lyl.foundation.spi;

public interface Provider {

    Class<? extends Provider> getType();
    String getProperty(String name, String defaultValue);
    void initialize();
}
