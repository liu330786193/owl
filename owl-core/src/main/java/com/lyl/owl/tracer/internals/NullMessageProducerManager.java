package com.lyl.owl.tracer.internals;

import com.lyl.owl.tracer.spi.MessageProducer;
import com.lyl.owl.tracer.spi.MessageProducerManager;

public class NullMessageProducerManager implements MessageProducerManager {

    private static final MessageProducer producer = new NullMessageProducer();

    @Override
    public MessageProducer getProducer() {
        return producer;
    }
}
