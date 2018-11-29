package com.lyl.owl.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@NoArgsConstructor
@ToString
public class ApolloConfig {

    private String appId;

    private String cluster;

    private String namespaceName;

    private Map<String, String> configurations;

    private String releaseKey;

    public ApolloConfig(String appId,
                        String cluster,
                        String namespaceName,
                        String releaseKey){
        this.appId = appId;
        this.cluster = cluster;
        this.namespaceName = namespaceName;
        this.releaseKey = releaseKey;
    }


}
