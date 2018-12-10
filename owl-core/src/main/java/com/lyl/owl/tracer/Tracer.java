package com.lyl.owl.tracer;

import com.lyl.owl.tracer.internals.NullMessageProducerManager;
import com.lyl.owl.tracer.spi.MessageProducer;
import com.lyl.owl.tracer.spi.MessageProducerManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Tracer {

    private static final MessageProducerManager NULL_MESSAGE_PRODUCER_MANAGER = new NullMessageProducerManager();
    private static volatile  MessageProducerManager producerManager;
    private static Object lock = new Object();

    private static MessageProducer getProducer(){
        try {
            if (producerManager == null){
                synchronized (lock){
                    if (producerManager == null){
                        producerManager = Serverboo
                    }
                }
            }
        } catch (Throwable ex){

        }
    }


}
