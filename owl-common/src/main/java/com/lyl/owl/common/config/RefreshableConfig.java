package com.lyl.owl.common.config;

import com.google.common.base.Splitter;
import com.lyl.owl.core.utils.ApolloThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class RefreshableConfig {

    private static final String LIST_SEPARATOR = ",";
    private static final int CONFIG_REFRESH_INTERVAL = 60;
    protected Splitter splitter = Splitter.on(LIST_SEPARATOR).omitEmptyStrings().trimResults();

    @Autowired
    private ConfigurableEnvironment environment;

    private List<RefreshablePropertySource> propertySources;
    protected abstract List<RefreshablePropertySource> getRefreshablePropertySources();

    @PostConstruct
    public void setUp(){
        propertySources = getRefreshablePropertySources();
        if (CollectionUtils.isEmpty(propertySources)){
            throw new IllegalStateException("Property sources can not be empty.");
        }

        //add property source to environment
        for (RefreshablePropertySource propertySource : propertySources){
            propertySource.refresh();
            environment.getPropertySources().addLast(propertySource);
        }

        //tasks to update configs
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1,
                ApolloThreadFactory.create("ConfigRefresher", true));

        executorService
                .scheduleWithFixedDelay(() -> {
                   try {
                       propertySources.forEach(RefreshablePropertySource::refresh);
                   } catch (Throwable t){
                       log.error("Refresh configs failed.", t);
                   }
                }, CONFIG_REFRESH_INTERVAL, CONFIG_REFRESH_INTERVAL, TimeUnit.SECONDS);

    }

    public int getIntProperty(String key, int defaultValue){
        try {

        }
    }

    public String getValue(String key, String defaultValue){
        try {
            return environment.getProperty(key, defaultValue);
        } catch (Throwable e){
            tracer
        }
        return environment.getProperty(key);
    }

    public String getValue(String key){
        return environment.getProperty(key);
    }

}










