package com.lyl.owl.tracer.internals;

import com.lyl.owl.core.utils.ClassLoaderUtil;
import com.lyl.owl.tracer.internals.cat.CatMessageProducer;
import com.lyl.owl.tracer.internals.cat.CatNames;
import com.lyl.owl.tracer.spi.MessageProducer;
import com.lyl.owl.tracer.spi.MessageProducerManager;

public class DefaultMessageProducerManager implements MessageProducerManager {

    private static MessageProducer producer;

    public DefaultMessageProducerManager(){
        if (ClassLoaderUtil.isClassPresent(CatNames.CAT_CLASS)){
            producer = new CatMessageProducer();
        } else {
            producer = new NullMessageProducerManager().getProducer();
        }
    }

    @Override
    public MessageProducer getProducer() {
        return producer;
    }
}
