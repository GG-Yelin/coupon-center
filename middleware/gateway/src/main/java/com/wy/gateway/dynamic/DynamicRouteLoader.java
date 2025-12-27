package com.wy.gateway.dynamic;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DynamicRouteLoader implements InitializingBean {

    @Autowired
    private NacosConfigManager configService;

    @Autowired
    private NacosConfigProperties configProperties;

    @Autowired
    private DynamicRoutesListener dynamicRoutesListener;

    private static final String ROUTES_CONFIG = "routes-config.json";

    @Override
    public void afterPropertiesSet() throws Exception {
        // 首次加载配置
        String routes = configService.getConfigService().getConfig(
                ROUTES_CONFIG, configProperties.getGroup(), 10000);
        dynamicRoutesListener.receiveConfigInfo(routes);

        // 注册监听器
        configService.getConfigService().addListener(
                ROUTES_CONFIG, configProperties.getGroup(), dynamicRoutesListener
        );

    }
}
