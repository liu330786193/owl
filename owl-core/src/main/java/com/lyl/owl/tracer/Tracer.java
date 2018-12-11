package com.lyl.owl.tracer;

import com.lyl.foundation.ServiceBootstrap;
import com.lyl.owl.tracer.internals.NullMessageProducerManager;
import com.lyl.owl.tracer.spi.MessageProducer;
import com.lyl.owl.tracer.spi.MessageProducerManager;
import com.lyl.owl.tracer.spi.Transaction;
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
                        producerManager = ServiceBootstrap.loadFirst(MessageProducerManager.class);
                    }
                }
            }
        } catch (Throwable ex){
            log.error("Failed to initialize message producer manager, use null message producer manager.", ex);
            producerManager = NULL_MESSAGE_PRODUCER_MANAGER;
        }
        return producerManager.getProducer();
    }

    public static void logError(String message, Throwable cause) {
        try {
            getProducer().logError(message, cause);
        } catch (Throwable ex){
            log.warn("Failed to log error for message: {}, cause: {}", message, cause, ex);
        }
    }

    public static void logError(Throwable cause) {
        try {
            getProducer().logError(cause);
        } catch (Throwable ex) {
            log.warn("Failed to log error for cause: {}", cause, ex);
        }
    }

    public static void logEvent(String type, String name) {
        try {
            getProducer().logEvent(type, name);
        } catch (Throwable ex) {
            log.warn("Failed to log event for type: {}, name: {}", type, name, ex);
        }
    }

    public static void logEvent(String type, String name, String status, String nameValuePairs) {
        try {
            getProducer().logEvent(type, name, status, nameValuePairs);
        } catch (Throwable ex) {
            log.warn("Failed to log event for type: {}, name: {}, status: {}, nameValuePairs: {}",
                    type, name, status, nameValuePairs, ex);
        }
    }

    public static Transaction newTransaction(String type, String name) {
        try {
            return getProducer().newTransaction(type, name);
        } catch (Throwable ex) {
            log.warn("Failed to create transaction for type: {}, name: {}", type, name, ex);
            return NULL_MESSAGE_PRODUCER_MANAGER.getProducer().newTransaction(type, name);
        }
    }

}






























