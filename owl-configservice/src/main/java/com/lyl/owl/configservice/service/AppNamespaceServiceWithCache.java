package com.lyl.owl.configservice.service;

import com.google.common.base.Joiner;
import com.lyl.owl.biz.repository.AppNamespaceRepository;
import com.lyl.owl.configservice.ConfigConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppNamespaceServiceWithCache implements InitializingBean {

    private static final Joiner STRING_JOINER = Joiner.on(ConfigConsts.CLUSTER_NAMESPACE_SEPARATOR)
            .skipNulls();
    @Autowired
    private AppNamespaceRepository appNamespaceRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
