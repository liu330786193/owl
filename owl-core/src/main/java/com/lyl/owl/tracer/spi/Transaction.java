package com.lyl.owl.tracer.spi;

public interface Transaction {

    String SUCCESS = "0";

    void setStatus(String status);
    void setStatus(Throwable e);
    void addData(String key, Object value);
    void complete();

}
