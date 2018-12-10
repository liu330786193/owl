package com.lyl.foundation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.ProviderManager;

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

            }
        } catch (Throwable ex){
            s_manager = new NullProvi
        }
    }

}
