package com.lyl.owl.configservice;

import com.lyl.owl.biz.OwlBizConfig;
import com.lyl.owl.common.OwlCommonConfig;
import com.lyl.owl.metaservice.OwlMetaServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author lyl
 * @Description
 * @Date 2018/11/26 10:07 AM
 */
@EnableEurekaServer
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:configservice.properties"})
@ComponentScan(basePackageClasses = {OwlCommonConfig.class,
        OwlBizConfig.class,
        OwlConfigServiceApplication.class,
        OwlMetaServiceConfig.class
    })
public class OwlConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwlConfigServiceApplication.class, args);



    }



}
