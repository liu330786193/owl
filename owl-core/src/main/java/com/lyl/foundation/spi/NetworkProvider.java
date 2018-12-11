package com.lyl.foundation.spi;

public interface NetworkProvider extends Provider {

    String getHostAddress();
    String getHostName();

}
