package com.lyl.owl.tracer.spi;

public interface MessageProducerManager {

    /**
     * 返回消息生产者
     */
    MessageProducer getProducer();

}
