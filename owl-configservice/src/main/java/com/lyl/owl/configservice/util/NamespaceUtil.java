package com.lyl.owl.configservice.util;

import com.lyl.owl.configservice.service.AppNamespaceServiceWithCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamespaceUtil {

    @Autowired
    private AppNamespaceServiceWithCache appNamespaceServiceWithCache;

    public String filterNamespaceName(String namespaceName){
        if (namespaceName.toLowerCase().endsWith(".properties")){
            int dotIndex = namespaceName.lastIndexOf(".");
            return namespaceName.substring(0, dotIndex);
        }
        return namespaceName;
    }

}
