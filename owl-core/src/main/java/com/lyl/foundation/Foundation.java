package com.lyl.foundation;

import com.lyl.foundation.internals.NullProviderManager;
import com.lyl.foundation.spi.ProviderManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Foundation {

    private static Object lock = new Object();
    private static volatile ProviderManager s_manager;

    static {
        getManager();
    }

    private static ProviderManager getManager(){
        try {
            if (s_manager == null) {
                synchronized (lock){
                    if (s_manager == null){
                        s_manager = ServiceBootstrap.loadFirst(ProviderManager.class);
                    }
                }
            }
            return s_manager;
        } catch (Throwable ex){
            s_manager = new NullProviderManager();
            log.error("Initialize ProviderManager failed.", ex);
            return s_manager;
        }
    }

}
