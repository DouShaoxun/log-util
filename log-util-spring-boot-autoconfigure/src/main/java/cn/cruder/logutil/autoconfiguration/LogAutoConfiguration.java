package cn.cruder.logutil.autoconfiguration;

import cn.cruder.logutil.aop.AopLoggerAspect;
import cn.cruder.logutil.properties.LogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * EnableConfigurationProperties可以使LogProperties注入spring容器
 *
 * @author dousx
 * @date 2022-04-22 13:43
 */
@Configuration
@EnableConfigurationProperties(LogProperties.class)
public class LogAutoConfiguration {

    @Order(-10)
    @Bean(value = "cruder_aopLoggerAspect")
    public AopLoggerAspect aopLoggerAspect(@Autowired LogProperties logProperties) {
        return new AopLoggerAspect(logProperties);
    }

}
