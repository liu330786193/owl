package com.lyl.owl.metaservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

/**
 * @Author lyl
 * @Description
 * @Date 2018/11/26 10:49 AM
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = {OwlMetaServiceConfig.class})
public class OwlMetaServiceConfig {
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall(){
        return new DefaultHttpFirewall();
    }
}
