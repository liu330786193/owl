package com.lyl.owl.common.config;

import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public abstract class RefreshablePropertySource extends MapPropertySource {

    public RefreshablePropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    protected abstract void refresh();

}
