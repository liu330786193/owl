package com.lyl.owl.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lyl
 * @Description
 * @Date 2018/11/26 10:17 AM
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = OwlCommonConfig.class)
public class OwlCommonConfig {
}
