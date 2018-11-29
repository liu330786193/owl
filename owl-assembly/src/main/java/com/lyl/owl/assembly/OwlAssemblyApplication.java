package com.lyl.owl.assembly;

import com.lyl.owl.configservice.OwlConfigServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author lyl
 * @Description
 * @Date 2018/11/23 6:12 PM
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class OwlAssemblyApplication {

    public static void main(String[] args) {
        /**
         * Common
         */
        ConfigurableApplicationContext commonContext =
                new SpringApplicationBuilder(OwlAssemblyApplication.class).web(WebApplicationType.NONE).run(args);
        log.info(commonContext.getId() + " isActive: " + commonContext.isActive());

        /**
         * ConfigService
         */
        if (commonContext.getEnvironment().containsProperty("configservice")){
            ConfigurableApplicationContext configContext =
                    new SpringApplicationBuilder(OwlConfigServiceApplication.class)
                    .parent(commonContext)
                    .sources(RefreshScope.class).run(args);
            log.info(configContext.getId() + " isActive: " + configContext.isActive());
        }

    }

}
