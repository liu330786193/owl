package com.lyl.owl.tracer.internals;

import com.lyl.owl.core.utils.ClassLoaderUtil;
import com.lyl.owl.tracer.spi.MessageProducer;
import com.lyl.owl.tracer.spi.MessageProducerManager;
import org.apache.logging.log4j.message.Message;

public class DefaultMessageProducerManager implements MessageProducerManager {

    private static MessageProducer producer;

    public DefaultMessageProducerManager(){
        if (ClassLoaderUtil.isClassPresent(Catna))
    }

    @Override
    public MessageProducer getProducer() {
        return null;
    }
}
