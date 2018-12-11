package com.lyl.foundation.spi;


import java.io.IOException;
import java.io.InputStream;

public interface ServerProvider extends Provider {

    String getEnvType();
    boolean isEnvTypeSet();
    String getDataCenter();
    boolean isDataCenterSet();
    void initialize(InputStream in) throws IOException;

}
