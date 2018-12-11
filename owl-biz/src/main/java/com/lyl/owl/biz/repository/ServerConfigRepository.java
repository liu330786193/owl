package com.lyl.owl.biz.repository;

import com.lyl.owl.biz.entity.ServerConfig;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServerConfigRepository extends PagingAndSortingRepository<ServerConfig, Long> {
    ServerConfig findTopByKeyAndCluster(String key, String cluster);
}
