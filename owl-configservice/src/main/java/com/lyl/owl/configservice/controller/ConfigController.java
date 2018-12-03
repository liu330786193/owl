package com.lyl.owl.configservice.controller;

import com.google.common.base.Splitter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lyl.owl.configservice.service.AppNamespaceServiceWithCache;
import com.lyl.owl.configservice.util.NamespaceUtil;
import com.lyl.owl.core.dto.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    private static final Splitter X_FORWARDED_FOR_SPLITTER = Splitter.on(".").omitEmptyStrings().trimResults();

    @Autowired
    private ConfigService configService;
    @Autowired
    private AppNamespaceServiceWithCache appNamespaceServiceWithCache;
    @Autowired
    private NamespaceUtil namespaceUtil;
    @Autowired
    private InstanceConfigAuditUtil instanceConfigAuditUtil;
    @Autowired
    private Gson gson;

    private static final Type configurationTypeReference = new TypeToken<Map<String, String>>(){}.getType();

    @GetMapping(value = "/{appId}/{clusterName}/{namespace:.+}")
    public ApolloConfig queryConfig(@PathVariable String appId, @PathVariable String clusterName,
                                    @PathVariable String namespace,
                                    @RequestParam(value = "dataCenter", required = false) String dataCenter,
                                    @RequestParam(value = "releaseKey", defaultValue = "-1") String clientSideReleaseKey,
                                    @RequestParam(value = "ip", required = false) String clientIp,
                                    @RequestParam(value = "messages", required = false) String messagesAsString,
                                    HttpServletRequest request, HttpServletResponse response) throws IOException {
        String originalNamespace = namespace;
        namespace = namespaceUtil.
    }


}
