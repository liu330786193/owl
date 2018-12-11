package com.lyl.owl.biz.service;

import com.google.common.collect.Maps;
import com.lyl.owl.biz.repository.ServerConfigRepository;
import com.lyl.owl.common.config.RefreshablePropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class BizDBPropertySource extends RefreshablePropertySource {

    @Autowired
    private ServerConfigRepository serverConfigRepository;

    public BizDBPropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    public BizDBPropertySource(){
        super("DBConfig", Maps.newConcurrentMap());
    }

    String getCurrentDataCenter(){
        return Fouda
    }

    @Override
    protected void refresh() {

    }
}
