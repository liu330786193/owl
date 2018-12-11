package com.lyl.owl.biz.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lyl.owl.common.config.RefreshableConfig;
import com.lyl.owl.common.config.RefreshablePropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Component
public class BizConfig extends RefreshableConfig {

    private static final int DEFAULT_ITEM_KEY_LENGTH = 128;
    private static final int DEFAULT_ITEM_VALUE_LENGTH = 20000;
    private static final int DEFAULT_APPNAMESPACE_CACHE_REBUILD_INTERVAL = 60; //60s
    private static final int DEFAULT_GRAY_RELEASE_RULE_SCAN_INTERVAL = 60; //60s
    private static final int DEFAULT_APPNAMESPACE_CACHE_SCAN_INTERVAL = 1; //1s
    private static final int DEFAULT_RELEASE_MESSAGE_CACHE_SCAN_INTERVAL = 1; //1s
    private static final int DEFAULT_RELEASE_MESSAGE_SCAN_INTERVAL_IN_MS = 1000; //1000ms
    private static final int DEFAULT_RELEASE_MESSAGE_NOTIFICATION_BATCH = 100;
    private static final int DEFAULT_RELEASE_MESSAGE_NOTIFICATION_BATCH_INTERVAL_IN_MILLI = 100;//100ms

    private Gson gson = new Gson();
    private static final Type namespaceValueLengthOverrideTypeReference =
            new TypeToken<Map<Long, Integer>>() {
            }.getType();

    @Autowired
    private BizDb

    @Override
    protected List<RefreshablePropertySource> getRefreshablePropertySources() {
        return null;
    }
}
