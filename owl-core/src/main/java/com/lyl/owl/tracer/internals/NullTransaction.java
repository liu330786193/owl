package com.lyl.owl.tracer.internals;

import com.lyl.owl.tracer.spi.Transaction;

public class NullTransaction implements Transaction {
    @Override
    public void setStatus(String status) {

    }

    @Override
    public void setStatus(Throwable e) {

    }

    @Override
    public void addData(String key, Object value) {

    }

    @Override
    public void complete() {

    }
}
