package com.lyl.owl.biz;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lyl
 * @Description
 * @Date 2018/11/26 10:44 AM
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackageClasses = OwlBizConfig.class)
public class OwlBizConfig {
}
